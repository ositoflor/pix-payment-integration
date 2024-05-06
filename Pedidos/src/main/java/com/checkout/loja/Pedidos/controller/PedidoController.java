package com.checkout.loja.Pedidos.controller;


import com.checkout.loja.Pedidos.dto.PagamentoDto;
import com.checkout.loja.Pedidos.dto.PedidoRequestDto;
import com.checkout.loja.Pedidos.dto.PedidoResponseDto;
import com.checkout.loja.Pedidos.exception.BussinesException;
import com.checkout.loja.Pedidos.helper.PedidoHelper;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/pedido")
public class PedidoController {

    @Autowired
    private PedidoHelper pedidoHelper;



    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<PedidoResponseDto> cadastrarPedido(@RequestBody @Valid PedidoRequestDto pedidoRequestDto) throws BussinesException {
        try {
            return ResponseEntity.ok().body(pedidoHelper.cadastrarLoja(pedidoRequestDto));
        }catch (BussinesException e) {
            throw new BussinesException(e.getMessage());
        }
    }

    @KafkaListener(topics = "pagamento", containerFactory = "pagamentoKafkaListenerFactory", groupId = "group_pagamento")
    private void pagamentoListen(@Payload PagamentoDto pagamentoDto) throws BussinesException {
        try {
            pedidoHelper.atualizarStatusPagamento(pagamentoDto);
        }catch (BussinesException e) {
            throw new BussinesException(e.getMessage());
        }
    }
}
