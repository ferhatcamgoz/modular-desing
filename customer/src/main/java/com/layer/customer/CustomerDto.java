package com.layer.customer;

import com.layer.basket.customer.BasketDto;

public class CustomerDto {

    private long id;

    private String name;

    private BasketDto basket;

    public CustomerDto(Customer customer) {
        this.id = customer.getId();
        this.name = customer.getName();
        if(customer.getBasket() != null)
            this.basket = new BasketDto(customer.getBasket());
    }

    public CustomerDto(String name, BasketDto basket) {
        this.name = name;
        this.basket = basket;
    }
    public CustomerDto() {

    }


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BasketDto getBasket() {
        return basket;
    }

    public void setBasket(BasketDto basket) {
        this.basket = basket;
    }

    @Override
    public String toString() {
        return "CustomerDto{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
