package com.checkout.loja.Pedidos.service.impl;

import com.checkout.loja.Pedidos.dto.PagamentoPixQrcodeDto;
import com.checkout.loja.Pedidos.dto.PedidoRequestDto;
import com.checkout.loja.Pedidos.service.IPagamentoService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Service
public class PagamentoService implements IPagamentoService {

    @Value("${base.url.pagamento}")
    private  String BASE_URL;
    private final WebClient webClient;

    public PagamentoService() {
        this.webClient = WebClient.create(BASE_URL);
    }

    @Override
    public Mono<PagamentoPixQrcodeDto> gerarQrCodePagamento(PedidoRequestDto pedidoRequestDto) {
        return webClient.post()
                .uri("/pix/gerarQRCode")
                .contentType(MediaType.APPLICATION_JSON)
                .body(BodyInserters.fromValue(pedidoRequestDto))
                .retrieve()
                .bodyToMono(PagamentoPixQrcodeDto.class);
    }
}
