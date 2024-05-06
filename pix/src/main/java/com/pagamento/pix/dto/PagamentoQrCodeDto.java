package com.pagamento.pix.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class PagamentoQrCodeDto {

    private long idPedido;
    private Double valor;
    private String qrCode;
}
