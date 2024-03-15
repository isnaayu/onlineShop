package com.enigma.onlineShop.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder(toBuilder = true)
public class AuthRequest {
    private String address;
    private String mobilePhone;
    private String name;
    private String username;
    private  String password;
    private String email;
}
