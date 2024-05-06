package com.checkout.loja.Pedidos.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
public class PedidoRequestDto {
    private long idPedido;

    @NotNull(message = "O valor do pedido é obrigatório e não pode ser nulo ou vazio.")
    private Double valorTotal;
}
