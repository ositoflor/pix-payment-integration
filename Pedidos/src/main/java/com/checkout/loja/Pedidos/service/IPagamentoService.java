package com.checkout.loja.Pedidos.service;


import com.checkout.loja.Pedidos.dto.PagamentoPixQrcodeDto;
import com.checkout.loja.Pedidos.dto.PedidoRequestDto;
import reactor.core.publisher.Mono;

public interface IPagamentoService {
    Mono<PagamentoPixQrcodeDto> gerarQrCodePagamento(PedidoRequestDto pedidoRequestDto);
}
