package com.layer.customer;

import com.layer.basket.model.Basket;
import com.layer.common.BaseEntity;
import jakarta.persistence.OneToOne;

import jakarta.persistence.Entity;

@Entity
public class Customer extends BaseEntity {

    private String name;

    @OneToOne
    private Basket basket;

    public Customer(String name) {
        this.name = name;
    }

    public Customer() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Basket getBasket() {
        return basket;
    }

    public void setBasket(Basket basket) {
        this.basket = basket;
    }
}
