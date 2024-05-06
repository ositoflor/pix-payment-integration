package com.pagamento.pix.controller;

import com.pagamento.pix.dto.PagamentoQrCodeDto;
import com.pagamento.pix.helper.PixHelper;
import com.pagamento.pix.dto.DadosConfirmacaoPagamentoDto;
import com.pagamento.pix.dto.DadosPedidoDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("pix")
public class PixController {

    @Autowired
    private PixHelper pixHelper;

    @PostMapping("/gerarQRCode")
    public ResponseEntity<PagamentoQrCodeDto> gerarQRCode(@RequestBody DadosPedidoDto dadosPedidoDto) {
        PagamentoQrCodeDto qrCode = pixHelper.gerarQRCodeParaPedido(dadosPedidoDto);
        return ResponseEntity.ok(qrCode);
    }

    @PostMapping("/confirmarPagamento")
    public ResponseEntity<DadosConfirmacaoPagamentoDto> confirmarPagamento(@RequestBody DadosConfirmacaoPagamentoDto dadosConfirmacao) {
        return ResponseEntity.ok(pixHelper.confirmarPagamento(dadosConfirmacao));
    }
}
