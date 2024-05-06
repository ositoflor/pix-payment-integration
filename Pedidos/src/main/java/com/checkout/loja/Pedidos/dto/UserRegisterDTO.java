package com.checkout.loja.Pedidos.dto;


import com.checkout.loja.Pedidos.entity.ENUM.RolesEnum;
import lombok.Data;

@Data
public class UserRegisterDTO extends AuthenticationDTO {
    private RolesEnum role;
}
