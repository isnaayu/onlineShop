package com.enigma.onlineShop.service.impl;

import com.enigma.onlineShop.dto.request.OrderRequest;
import com.enigma.onlineShop.repository.OrderRepository;
import com.enigma.onlineShop.dto.response.*;
import com.enigma.onlineShop.entity.*;
import com.enigma.onlineShop.service.CustomerService;
import com.enigma.onlineShop.service.OrderService;
import com.enigma.onlineShop.service.ProductPriceService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {
    private final OrderRepository orderRepository;
    private final CustomerService customerService;
    private final ProductPriceService productPriceService;

    @Transactional(rollbackOn = Exception.class)
    @Override
    public OrderResponse create(OrderRequest orderRequest) {
        CustomerResponse customerResponse = customerService.getById(orderRequest.getCustomerId());
        List<OrderDetail> orderDetails = orderRequest.getOrderDetails().stream().map(orderDetailRequest -> {
            ProductPrice productPrice = productPriceService.getById(orderDetailRequest.getProductPriceId());
            return OrderDetail.builder()
                    .productPrice(productPrice)
                    .quantity(orderDetailRequest.getQuantity())
                    .build();
        }).toList();
        Order order = Order.builder()
                .customer(Customer.builder()
                        .id(customerResponse.getId())
                        .build())
                .transDate(LocalDateTime.now())
                .orderDetails(orderDetails)
                .build();
        orderRepository.saveAndFlush(order);

        List<OrderDetailResponse> orderDetailResponses = order.getOrderDetails().stream().map(orderDetail -> {
            orderDetail.setOrder(order);
            System.out.println(order);
            ProductPrice currentProductPrice = orderDetail.getProductPrice();
            currentProductPrice.setStock(currentProductPrice.getStock() - orderDetail.getQuantity());
            return OrderDetailResponse.builder()
                    .orderDetailsId(orderDetail.getId())
                    .quantity(orderDetail.getQuantity())
                    .product(ProductResponse.builder()
                            .ProductId(currentProductPrice.getId())
                            .ProductName(currentProductPrice.getProduct().getName())
                            .description(currentProductPrice.getProduct().getDescription())
                            .stock(currentProductPrice.getStock())
                            .price(currentProductPrice.getPrice())
                            .store(StoreResponse.builder()
                                    .id(currentProductPrice.getId())
                                    .storeName(currentProductPrice.getStore().getName())
                                    .noSiup(currentProductPrice.getStore().getNoSiup())
                                    .address(currentProductPrice.getStore().getAddress())
                                    .phone(currentProductPrice.getStore().getMobilePhone())
                                    .build())
                            .build())
                    .build();
        }).toList();
        return OrderResponse.builder()
                .orderId(order.getId())
                .customer(customerResponse)
                .orderDetails(orderDetailResponses)
                .transDate(order.getTransDate())
                .build();
    }

    @Override
    public OrderResponse getById(String id) {
        return null;
    }

    @Override
    public List<OrderResponse> getAllOrder() {
        return null;
    }
}