package com.pagamento.pix.dto;

import com.pagamento.pix.dto.Enum.StatusPagamento;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DadosConfirmacaoPagamentoDto {

    private long idPedido;
    private StatusPagamento status;
}
