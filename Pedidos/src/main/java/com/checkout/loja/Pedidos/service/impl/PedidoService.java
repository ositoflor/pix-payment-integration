package com.checkout.loja.Pedidos.service.impl;

import com.checkout.loja.Pedidos.entity.Pedido;
import com.checkout.loja.Pedidos.repository.PedidoRepository;
import com.checkout.loja.Pedidos.service.IPedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PedidoService implements IPedidoService {

    @Autowired
    private PedidoRepository pedidoRepository;

    @Override
    public Pedido savePedido(Pedido pedido) {
        return pedidoRepository.save(pedido);
    }

    @Override
    public Optional<Pedido> findById(Long id) {
        return pedidoRepository.findById(id);
    }

    @Override
    public Pedido atualizarStatus(Pedido pedido) {
        return pedidoRepository.save(pedido);
    }
}
