package com.enigma.onlineShop.service.impl;

import com.enigma.onlineShop.repository.ProductPriceRepository;
import com.enigma.onlineShop.service.ProductPriceService;
import com.enigma.onlineShop.entity.ProductPrice;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
@RequiredArgsConstructor
public class ProductPriceServiceImpl implements ProductPriceService {
    private final ProductPriceRepository productPriceRepository;

    @Override
    public ProductPrice create(ProductPrice productPrice) {
        return productPriceRepository.save(productPrice);
    }

    @Override
    public ProductPrice getById(String id) {
        return productPriceRepository.findById(id).orElseThrow();
    }

    @Override
    public ProductPrice findProductPriceIsActive(String productId, boolean actice) {
        return productPriceRepository.findByProduct_IdAndIsActive(productId, actice).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Product not found"));
    }
}
