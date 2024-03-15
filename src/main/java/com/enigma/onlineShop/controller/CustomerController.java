package com.enigma.onlineShop.controller;

import com.enigma.onlineShop.dto.request.CustomerRequest;
import com.enigma.onlineShop.dto.response.CustomerResponse;
import com.enigma.onlineShop.constant.AppPath;
import com.enigma.onlineShop.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(AppPath.CUSTOMER)
public class CustomerController {
    public final CustomerService customerService;

    @PostMapping
    public CustomerResponse create(@RequestBody CustomerRequest customerRequest){
        return customerService.create(customerRequest);
    }

    @GetMapping
    public List<CustomerResponse> getAll(){
        return customerService.getAll();
    }

    @GetMapping("{id}")
    public CustomerResponse getById(@PathVariable String id){
        return customerService.getById(id);
    }

    @PutMapping
    public CustomerResponse update(@RequestBody CustomerRequest customerRequest){
        return customerService.update(customerRequest);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable String id){
        customerService.delete(id);
    }

}
