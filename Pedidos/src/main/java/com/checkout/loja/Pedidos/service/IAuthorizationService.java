package com.checkout.loja.Pedidos.service;


import com.checkout.loja.Pedidos.dto.UserRegisterDTO;
import com.checkout.loja.Pedidos.dto.UserResponseDTO;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface IAuthorizationService extends UserDetailsService {

    UserResponseDTO register(UserRegisterDTO dto);

}
