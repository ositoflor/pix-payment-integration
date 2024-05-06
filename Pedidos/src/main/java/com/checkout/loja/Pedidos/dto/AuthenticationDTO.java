package com.checkout.loja.Pedidos.dto;


import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class AuthenticationDTO {

    @NotBlank(message = "O Login é obrigatório e não pode ser nulo ou vazio.")
    private String login;

    @NotBlank(message = "A senha é obrigatória e não pode ser nulo ou vazio.")
    private String password;

}
