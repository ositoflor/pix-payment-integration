package com.checkout.loja.Pedidos.entity.ENUM;

public enum RolesEnum {
    ADMIN("admin"),
    USER("user");

    private String role;

    RolesEnum(String role) {
        this.role = role;
    }

    public String getRole(){
        return role;
    }
}
