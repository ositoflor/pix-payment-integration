package com.checkout.loja.Pedidos.dto;


import com.checkout.loja.Pedidos.entity.ENUM.RolesEnum;
import com.checkout.loja.Pedidos.entity.User;
import lombok.Data;

@Data
public class UserResponseDTO {

    private Long id;
    private String login;
    private RolesEnum role;

    public UserResponseDTO(User entity) {
        this.id = entity.getId();
        this.login = entity.getLogin();
        this.role = entity.getRole();
    }
}
