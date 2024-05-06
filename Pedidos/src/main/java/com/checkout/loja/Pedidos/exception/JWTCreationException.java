package com.checkout.loja.Pedidos.exception;

public class JWTCreationException extends RuntimeException{

    public JWTCreationException(String mensagem) {
        super(mensagem);
    }

    public JWTCreationException(String mensagem, Throwable causa) {
        super(mensagem, causa);
    }
}
