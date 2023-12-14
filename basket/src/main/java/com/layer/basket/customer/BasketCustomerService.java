package com.layer.basket.customer;


import com.layer.basket.model.Basket;

public interface BasketCustomerService {
    BasketDto getBasket(long customerId);

    Basket createBasket();
}
