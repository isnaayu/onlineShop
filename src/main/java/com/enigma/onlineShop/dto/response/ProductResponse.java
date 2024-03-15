package com.enigma.onlineShop.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
public class ProductResponse {
    private String ProductId;
    private String ProductName;
    private String description;
    private Long price;
    private Integer stock;
    private StoreResponse store;
//    private List<ProductPrice> productPriceList;
}
