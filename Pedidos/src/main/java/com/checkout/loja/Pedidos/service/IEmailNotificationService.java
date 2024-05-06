package com.checkout.loja.Pedidos.service;

import java.io.IOException;

public interface IEmailNotificationService {
    void sendEmail(String to, String subject, Long numeroPedido, String status, Double valor) throws IOException;
}
