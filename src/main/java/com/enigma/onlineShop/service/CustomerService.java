package com.enigma.onlineShop.service;

import com.enigma.onlineShop.dto.request.CustomerRequest;
import com.enigma.onlineShop.dto.response.CustomerResponse;
import com.enigma.onlineShop.entity.Customer;

import java.util.List;

public interface CustomerService {
    CustomerResponse create(CustomerRequest customerRequest);
    CustomerResponse createNewCustomer(Customer request);
    List<CustomerResponse> getAll();
    CustomerResponse getById(String id);
    void delete(String id);
    CustomerResponse update(CustomerRequest customerRequest);

}
