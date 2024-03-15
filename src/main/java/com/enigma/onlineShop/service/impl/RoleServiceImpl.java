package com.enigma.onlineShop.service.impl;

import com.enigma.onlineShop.repository.RoleRepository;
import com.enigma.onlineShop.entity.Role;
import com.enigma.onlineShop.service.RoleService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class RoleServiceImpl implements RoleService {
    private final RoleRepository roleRepository;
    @Override
    public Role getOrSave(Role role) {
        Optional<Role> optionalRole = roleRepository.findByName(role.getName());
        if (!optionalRole.isEmpty()) return optionalRole.get();
        return roleRepository.save(role);
    }
}
