package com.enigma.onlineShop.service;

import com.enigma.onlineShop.dto.request.AuthRequest;
import com.enigma.onlineShop.dto.response.LoginResponse;
import com.enigma.onlineShop.dto.response.RegisterResponse;

public interface AuthService {
    RegisterResponse registerCustomer(AuthRequest authRequest);

    LoginResponse login(AuthRequest authRequest);

    RegisterResponse registerAdmin(AuthRequest authRequest);
}
