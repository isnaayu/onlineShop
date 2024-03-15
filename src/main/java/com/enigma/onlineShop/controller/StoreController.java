package com.enigma.onlineShop.controller;

import com.enigma.onlineShop.dto.request.StoreRequest;
import com.enigma.onlineShop.dto.response.StoreResponse;
import com.enigma.onlineShop.entity.Store;
import com.enigma.onlineShop.constant.AppPath;
import com.enigma.onlineShop.service.StoreService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(AppPath.STORE)
public class StoreController {
    private final StoreService storeService;

    @GetMapping
    public List<Store> getAllStore(){
        return storeService.getAll();
    }
    @GetMapping("/{id}")
    public Store getById(@PathVariable String id){
        return storeService.getById(id);
    }

    @PutMapping
    public Store updateStore(@RequestBody Store store){
        return storeService.update(store);
    }

    @DeleteMapping("/store/{id}")
    public void deleteStore(@PathVariable String id){
        storeService.delete(id);
    }

    @PostMapping("/v1")
    public StoreResponse createStores(@RequestBody StoreRequest storeRequest){
        return storeService.create(storeRequest);
    }


}
