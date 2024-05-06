package com.checkout.loja.Pedidos.exception;

import lombok.Getter;

@Getter
public class ValidationFieldException extends RuntimeException{

    private static final long serialVersionUID = 1L;
    private int status;
    private String campo;
    private String mensagem;


    public ValidationFieldException(int status, String campo, String mensagem) {
        super();
        this.status = status;
        this.campo = campo;
        this.mensagem = mensagem;
    }
}
