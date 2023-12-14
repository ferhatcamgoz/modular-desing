package com.layer.basket;


import com.layer.basket.customer.BasketDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/basket")
public class BasketController {

    private final BasketService basketService;

    public BasketController(BasketService basketService) {
        this.basketService = basketService;
    }


    @GetMapping("/getBasket/{id}")
    public BasketDto getBasket(@PathVariable long id) {
        return basketService.getBasket(id);
    }

    @PostMapping("/addProduct/{basketId}/{quantity}/{productId}")
    public BasketDto addProductToBasket(@PathVariable long productId,  @PathVariable int quantity, @PathVariable long basketId) {
        return basketService.addProductToBasket(productId, quantity, basketId);
    }
    @DeleteMapping("/removeProduct/{basketId}/{productId}")
    public BasketDto removeProductFromBasket(@PathVariable long productId, @PathVariable long basketId) {
        return basketService.removeProductFromBasket(productId, basketId);
    }

    @GetMapping("/getBasket/{id}/total")
    public ResponseEntity<Double> getBasketTotal(@PathVariable long id) {
        return ResponseEntity.ok(basketService.getTotal(id));
    }

    


}
