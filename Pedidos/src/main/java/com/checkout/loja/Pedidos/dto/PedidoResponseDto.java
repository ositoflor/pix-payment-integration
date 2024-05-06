package com.checkout.loja.Pedidos.dto;

import com.checkout.loja.Pedidos.entity.ENUM.StatusPagamento;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class PedidoResponseDto {

    private long id;
    private LocalDateTime data;
    private Double valorTotal;
    private StatusPagamento status;
    private String qrCode;
}
