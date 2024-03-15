package com.enigma.onlineShop.service;

import com.enigma.onlineShop.dto.response.AdminResponse;
import com.enigma.onlineShop.entity.Admin;

public interface AdminService {
    AdminResponse createNewAdmin(Admin request);
}
