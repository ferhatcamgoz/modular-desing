package com.layer.basket.customer;

import com.layer.basket.model.Basket;
import com.layer.product.basket.ProductDto;

import java.util.List;
import java.util.stream.Collectors;

public class BasketDto {

    private List<ProductDto> products;
    private long id;

    public BasketDto(Basket basket) {
        this.id = basket.getId();
        this.products = basket.getProducts().stream().map(ProductDto::new).collect(Collectors.toList());
    }

    public BasketDto() {
    }

    public List<ProductDto> getProducts() {
        return products;
    }

    public void setProducts(List<ProductDto> products) {
        this.products = products;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }


}
