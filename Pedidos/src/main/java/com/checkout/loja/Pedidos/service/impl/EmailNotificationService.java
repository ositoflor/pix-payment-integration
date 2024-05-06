package com.checkout.loja.Pedidos.service.impl;

import com.checkout.loja.Pedidos.service.IEmailNotificationService;
import jakarta.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.messaging.MessagingException;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.text.NumberFormat;
import java.util.Locale;

@Service
public class EmailNotificationService implements IEmailNotificationService {

    @Autowired
    private JavaMailSender javaMailSender;

    @Autowired
    private EmailTemplateService emailTemplateService;
    @Override
    public void sendEmail(String to, String subject, Long numeroPedido, String status, Double valor) throws IOException {
        MimeMessage mimeMessage = javaMailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(mimeMessage);

        String templateContent = emailTemplateService.loadEmailTemplate();

        String valorFormatado = NumberFormat.getCurrencyInstance(new Locale("pt", "BR")).format(valor);

        templateContent = templateContent.replace("${numeroPedido}", numeroPedido.toString());
        templateContent = templateContent.replace("${status}", status);
        templateContent = templateContent.replace("${valor}", valorFormatado);
        try {
            helper.setTo(to);
            helper.setSubject(subject);
            helper.setText(templateContent, true); // Set to true if the body is HTML
            javaMailSender.send(mimeMessage);
        } catch (MessagingException e) {
            // Handle exception
            e.printStackTrace();
        } catch (jakarta.mail.MessagingException e) {
            throw new RuntimeException(e);
        }
    }
}
