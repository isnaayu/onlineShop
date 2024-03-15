package com.enigma.onlineShop.service;

import com.enigma.onlineShop.dto.request.ProductRequest;
import com.enigma.onlineShop.dto.response.ProductResponse;
import com.enigma.onlineShop.entity.Product;
import org.springframework.data.domain.Page;

import java.util.List;

public interface ProductService {
    ProductResponse create(ProductRequest productRequest);
//    List<ProductResponse> getAll();
    ProductResponse update(ProductRequest productRequest);
    ProductResponse getById(String id);
    void delete(String id);

    ProductResponse createProductAndProductPrice(ProductRequest productRequest);
    List<Product> getAll();

    Page<ProductResponse> getAllByNameOrPrice(String name, Long maxPrice, Integer page, Integer size);
}
