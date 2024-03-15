package com.enigma.onlineShop.service;

import com.enigma.onlineShop.entity.Role;

public interface RoleService {
    Role getOrSave(Role role);
}
