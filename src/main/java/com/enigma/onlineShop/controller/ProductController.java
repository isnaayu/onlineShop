package com.enigma.onlineShop.controller;

import com.enigma.onlineShop.dto.request.ProductRequest;
import com.enigma.onlineShop.dto.response.CommonResponse;
import com.enigma.onlineShop.dto.response.PagingResponse;
import com.enigma.onlineShop.dto.response.ProductResponse;
import com.enigma.onlineShop.entity.Product;
import com.enigma.onlineShop.constant.AppPath;
import com.enigma.onlineShop.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(AppPath.PRODUCT)
public class ProductController {
    private final ProductService productService;

    @PostMapping
    @PreAuthorize("hasRole('ADMIN')") //    @PreAuthorize("hasAnyRole('ADMIN', 'SUPER_ADMIN')")
    public ResponseEntity<?> createProduct(@RequestBody ProductRequest productRequest){
        ProductResponse productResponse = productService.createProductAndProductPrice(productRequest);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(CommonResponse.<ProductResponse>builder()
                        .statusCode(HttpStatus.CREATED.value())
                        .message("Successfully Created new Product")
                        .data(productResponse)
                        .build());
    }

//    @GetMapping
//    public List<ProductResponse> getAllProduct(){
//        return productService.getAll();
//    }

    @GetMapping
    @PreAuthorize("hasRole('ADMIN')")
    public List<Product> getAllProduct(){
        return productService.getAll();
    }

    @GetMapping("/{id}")
    public ProductResponse getById(@PathVariable String id){
        return productService.getById(id);
    }

    @GetMapping("/page")
    public ResponseEntity<?> getAlProductPage(
            @RequestParam(name = "name", required = false) String name,
            @RequestParam(name = "maxPrice", required = false) Long maxPrice,
            @RequestParam(name = "page", required = false, defaultValue = "0") Integer page,
            @RequestParam(name = "size", required = false, defaultValue = "5") Integer size
    ){
        Page<ProductResponse> productResponses = productService.getAllByNameOrPrice(name, maxPrice, page, size);
        PagingResponse pagingResponse = PagingResponse.builder()
                .currentPage(page)
                .size(size)
                .totalPage(productResponses.getTotalPages())
                .build();
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(CommonResponse.builder()
                        .statusCode(HttpStatus.CREATED.value())
                        .message("Successfully get all product")
                        .data(productResponses.getContent())
                        .paging(pagingResponse)
                        .build());
    }


}
