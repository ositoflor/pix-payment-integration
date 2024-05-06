package com.checkout.loja.Pedidos.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PagamentoPixQrcodeDto {
    private long idPedido;
    private String qrCode;
}
