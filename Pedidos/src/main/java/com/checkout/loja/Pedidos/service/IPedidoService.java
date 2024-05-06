package com.checkout.loja.Pedidos.service;

import com.checkout.loja.Pedidos.entity.Pedido;

import java.util.Optional;

public interface IPedidoService {
    Pedido savePedido(Pedido pedido);
    Optional<Pedido> findById(Long id);
    Pedido atualizarStatus(Pedido pedido);
}
