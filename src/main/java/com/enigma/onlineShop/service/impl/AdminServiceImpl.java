package com.enigma.onlineShop.service.impl;

import com.enigma.onlineShop.dto.response.AdminResponse;
import com.enigma.onlineShop.repository.AdminRepository;
import com.enigma.onlineShop.service.AdminService;
import com.enigma.onlineShop.entity.Admin;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AdminServiceImpl implements AdminService {
    private final AdminRepository adminRepository;

    @Override
    public AdminResponse createNewAdmin(Admin request) {
        Admin admin = adminRepository.saveAndFlush(request);
        return AdminResponse.builder()
                .id(admin.getId())
                .adminName(admin.getName())
                .Phone(admin.getPhoneNumber())
                .build();
    }
}
