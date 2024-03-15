package com.enigma.onlineShop.controller;

import com.enigma.onlineShop.dto.request.OrderRequest;
import com.enigma.onlineShop.dto.response.CommonResponse;
import com.enigma.onlineShop.dto.response.OrderResponse;
import com.enigma.onlineShop.constant.AppPath;
import com.enigma.onlineShop.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping(AppPath.ORDER)
public class OrderController {
    private final OrderService orderService;
    @PostMapping
    public ResponseEntity<?> createOrder(@RequestBody OrderRequest orderRequest){
        OrderResponse orderResponse = orderService.create(orderRequest);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(CommonResponse.builder()
                        .data(orderResponse)
                        .message("Succesfully Created Order")
                        .statusCode(HttpStatus.CREATED.value())
                        .build());
    }
}
