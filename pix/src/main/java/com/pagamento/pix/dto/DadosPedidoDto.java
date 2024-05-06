package com.pagamento.pix.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Setter
@Getter
public class DadosPedidoDto {

    private long idPedido;
    private Double valorTotal;
}
