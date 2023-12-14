package com.layer.basket;

import com.layer.basket.customer.BasketCustomerService;
import com.layer.basket.customer.BasketDto;

public interface BasketService extends BasketCustomerService {
    BasketDto addProductToBasket(long productId, int quantity, long customerId);

    BasketDto removeProductFromBasket(long productId, long customerId);
    void checkout(long customerId);

    double getTotal(long customerId);

  }
