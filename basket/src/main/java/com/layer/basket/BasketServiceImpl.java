package com.layer.basket;

import com.layer.basket.customer.BasketCustomerService;
import com.layer.basket.customer.BasketDto;
import com.layer.basket.model.Basket;
import com.layer.product.basket.BasketProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BasketServiceImpl implements BasketService, BasketCustomerService {

    private final BasketRepo basketRepo;

    private final BasketProductService basketProductService;

    @Autowired
    public BasketServiceImpl(BasketRepo basketRepo, BasketProductService basketProductService) {
        this.basketRepo = basketRepo;
        this.basketProductService = basketProductService;
    }

    @Override
    public BasketDto addProductToBasket(long productId, int quantity, long basketId) {
        Basket basket = basketRepo.findById(basketId).orElse(null);
        if(basket == null) {
            basket = new Basket();
        }

        if(basketProductService.getStock(productId) < quantity) {
            return new BasketDto();
        }

        basket.getProducts().add(basketProductService.getById(productId));
        return new BasketDto(basketRepo.save(basket));

    }

    @Override
    public BasketDto removeProductFromBasket(long productId, long basketId) {

        Basket basket = basketRepo.findById(basketId).orElse(null);
        if(basket == null) {
            return new BasketDto();
        }

        basket.getProducts().remove(basketProductService.getById(productId));
        return new BasketDto(basketRepo.save(basket));
    }

    @Override
    public void checkout(long customerId) {
        Basket basket = basketRepo.findById(customerId).orElse(null);
        if(basket == null) {
            return;
        }
        basket.getProducts().clear();
        basketRepo.save(basket);
    }

    @Override
    public double getTotal(long getBasketId) {

        Basket basket = basketRepo.findById(getBasketId).orElse(null);
        if (basket == null) {
            return 0;
        }

        return basket.getProducts().stream().mapToDouble(p -> p.getPrice()).sum();
    }

    @Override
    public BasketDto getBasket(long basketId) {
        Basket basket = basketRepo.findById(basketId).orElse(null);
        if(basket == null) {
            return new BasketDto();
        }
        return new BasketDto(basket);
    }

    @Override
    public Basket createBasket() {
        return basketRepo.save(new Basket());
    }
}
