package com.layer.product.basket;

import com.layer.product.model.Product;

import java.util.List;

public interface BasketProductService {

    List<ProductDto> getBasketProductsInfo(List<Long> productIds);

    Product getById(long productId);


    int getStock(long productId);

}
