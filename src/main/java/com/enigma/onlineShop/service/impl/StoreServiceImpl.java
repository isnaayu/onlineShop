package com.enigma.onlineShop.service.impl;

import com.enigma.onlineShop.dto.request.StoreRequest;
import com.enigma.onlineShop.dto.response.StoreResponse;
import com.enigma.onlineShop.entity.Store;
import com.enigma.onlineShop.repository.StoreRepository;
import com.enigma.onlineShop.service.StoreService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StoreServiceImpl implements StoreService {

    private final StoreRepository storeRepository;

    @Override
    public Store update(Store store) {
        Store currentStoreId = getById(store.getId());
        if (currentStoreId != null){
            return storeRepository.save(store);
        }
        return null;
    }

    @Override
    public void delete(String id) {
        storeRepository.deleteById(id);
    }

    @Override
    public List<Store> getAll() {
        return storeRepository.findAll();
    }

    @Override
    public Store getById(String id) {
        return storeRepository.findById(id).orElse(null);
    }


    @Override
    public StoreResponse create(StoreRequest storeRequest) {
        Store store = Store.builder()
                .name(storeRequest.getName())
                .noSiup(storeRequest.getNoSiup())
                .address(storeRequest.getAddress())
                .mobilePhone(storeRequest.getMobilePhone())
                .build();
        storeRepository.save(store);
        return StoreResponse.builder()
                .storeName(store.getName())
                .address(store.getAddress())
                .noSiup(store.getNoSiup())
                .phone(store.getMobilePhone())
                .build();
    }
}
