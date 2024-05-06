package com.pagamento.pix.helper;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;
import com.pagamento.pix.dto.DadosConfirmacaoPagamentoDto;
import com.pagamento.pix.dto.DadosPedidoDto;
import com.pagamento.pix.dto.PagamentoQrCodeDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

import java.io.ByteArrayOutputStream;
import java.util.Base64;

@Component
public class PixHelper {

    @Autowired
    private KafkaTemplate<String, DadosConfirmacaoPagamentoDto> kafkaTemplate;
    public PagamentoQrCodeDto gerarQRCodeParaPedido(DadosPedidoDto dadosPedidoDto) {
        String conteudo = "idPedido=".concat(String.valueOf(dadosPedidoDto.getIdPedido())).concat("&valor=").concat(dadosPedidoDto.getValorTotal().toString());

        QRCodeWriter qrCodeWriter = new QRCodeWriter();
        try {
            BitMatrix bitMatrix = qrCodeWriter.encode(conteudo, BarcodeFormat.QR_CODE, 200, 200);
            ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
            MatrixToImageWriter.writeToStream(bitMatrix, "PNG", outputStream);
            byte[] qrCodeBytes = outputStream.toByteArray();
            return PagamentoQrCodeDto.builder()
                    .qrCode(Base64.getEncoder().encodeToString(qrCodeBytes))
                    .idPedido(dadosPedidoDto.getIdPedido())
                    .valor(dadosPedidoDto.getValorTotal())
                    .build();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public DadosConfirmacaoPagamentoDto confirmarPagamento(DadosConfirmacaoPagamentoDto dadosConfirmacaoPagamentoDto) {
        kafkaTemplate.send("pagamento", dadosConfirmacaoPagamentoDto);
        return dadosConfirmacaoPagamentoDto;
    }
}
