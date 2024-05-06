package com.checkout.loja.Pedidos.helper;


import com.checkout.loja.Pedidos.dto.PagamentoDto;
import com.checkout.loja.Pedidos.dto.PagamentoPixQrcodeDto;
import com.checkout.loja.Pedidos.dto.PedidoRequestDto;
import com.checkout.loja.Pedidos.dto.PedidoResponseDto;
import com.checkout.loja.Pedidos.entity.Pedido;
import com.checkout.loja.Pedidos.exception.BussinesException;
import com.checkout.loja.Pedidos.service.impl.EmailNotificationService;
import com.checkout.loja.Pedidos.service.impl.PagamentoService;
import com.checkout.loja.Pedidos.service.impl.PedidoService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

import java.io.IOException;
import java.util.Objects;
import java.util.Optional;

@Component
public class PedidoHelper {

    @Autowired
    private PedidoService pedidoService;

    @Autowired
    PagamentoService pagamentoService;

    @Autowired
    private ModelMapper mapper;

    @Autowired
    private EmailNotificationService emailNotificationService;

    public PedidoResponseDto cadastrarLoja(PedidoRequestDto pedidoRequestDto) throws BussinesException {
        try {
            Pedido pedido = pedidoService.savePedido(mapper.map(pedidoRequestDto, Pedido.class));
            PedidoResponseDto responseDto = mapper.map(pedido,PedidoResponseDto.class);
            pedidoRequestDto.setIdPedido(responseDto.getId());
            Mono<PagamentoPixQrcodeDto> pagamentoDto = pagamentoService.gerarQrCodePagamento(pedidoRequestDto);
            responseDto.setQrCode(Objects.requireNonNull(pagamentoDto.block()).getQrCode());
            return responseDto;
        }catch (BussinesException e){
            throw new BussinesException(e.getMessage(), e.getCause());
        }
    }

    public void atualizarStatusPagamento(PagamentoDto pagamentoDto) throws BussinesException {
        try {
            Optional<Pedido> pedido = pedidoService.findById(pagamentoDto.getIdPedido());
            pedido.orElseThrow(() -> new BussinesException("Pedido não encontrado"));

            pedido.get().setStatus(pagamentoDto.getStatus());

            emailNotificationService.sendEmail("loja@email.com",
                    "Status Pedido N° 000".concat(String.valueOf(pedido.get().getId())),
                    pedido.get().getId(),
                    pedido.get().getStatus().getValue(),
                    pedido.get().getValorTotal());

            mapper.map(pedidoService.savePedido(pedido.get()), PedidoResponseDto.class);
        }catch (BussinesException e){
            throw new BussinesException(e.getMessage(), e.getCause());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
