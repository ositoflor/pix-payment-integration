package com.checkout.loja.Pedidos.exception;

public class BussinesException extends RuntimeException{

    public BussinesException(String mensagem) {
        super(mensagem);
    }

    public BussinesException(String mensagem, Throwable causa) {
        super(mensagem, causa);
    }
}
