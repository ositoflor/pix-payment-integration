package com.checkout.loja.Pedidos.dto;

import com.checkout.loja.Pedidos.entity.ENUM.StatusPagamento;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PagamentoDto {
    private long idPedido;
    private StatusPagamento status;
}
