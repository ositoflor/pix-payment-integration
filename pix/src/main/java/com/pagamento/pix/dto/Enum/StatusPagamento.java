package com.pagamento.pix.dto.Enum;

public enum StatusPagamento {
    PENDENTE("PENDENTE"),
    CONCLUIDO("CONCLUIDO"),
    CANCELADO("CANCELADO");

    private final String value;

    StatusPagamento(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
