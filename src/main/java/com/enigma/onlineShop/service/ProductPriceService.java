package com.enigma.onlineShop.service;

import com.enigma.onlineShop.entity.ProductPrice;

public interface ProductPriceService {
    ProductPrice create(ProductPrice productPrice);

    ProductPrice getById(String id);

    ProductPrice findProductPriceIsActive(String productId, boolean actice);
}
