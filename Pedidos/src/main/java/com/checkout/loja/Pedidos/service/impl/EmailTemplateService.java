package com.checkout.loja.Pedidos.service.impl;

import com.checkout.loja.Pedidos.service.IEmailTemplateService;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;

@Service
public class EmailTemplateService implements IEmailTemplateService {
    @Override
    public String loadEmailTemplate() throws IOException {

        Path templatePath = new ClassPathResource("templates/status-pedido.html").getFile().toPath();

        return Files.readString(templatePath, StandardCharsets.UTF_8);
    }
}
