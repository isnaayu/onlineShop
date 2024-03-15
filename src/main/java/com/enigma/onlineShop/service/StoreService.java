package com.enigma.onlineShop.service;

import com.enigma.onlineShop.dto.request.StoreRequest;
import com.enigma.onlineShop.dto.response.StoreResponse;
import com.enigma.onlineShop.entity.Store;

import java.util.List;

public interface StoreService{
    Store update(Store store);
    void delete(String id);
    List<Store> getAll();
    Store getById(String id);

    StoreResponse create(StoreRequest storeRequest);
}
