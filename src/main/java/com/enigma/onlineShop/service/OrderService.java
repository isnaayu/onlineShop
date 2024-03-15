package com.enigma.onlineShop.service;

import com.enigma.onlineShop.dto.request.OrderRequest;
import com.enigma.onlineShop.dto.response.OrderResponse;

import java.util.List;

public interface OrderService {
    OrderResponse create(OrderRequest orderRequest);
    OrderResponse getById(String id);
    List<OrderResponse> getAllOrder();
}
