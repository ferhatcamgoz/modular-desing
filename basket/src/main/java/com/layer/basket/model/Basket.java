package com.layer.basket.model;

import com.layer.common.BaseEntity;
import com.layer.product.model.Product;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;
@Entity
public class Basket extends BaseEntity {

    @OneToMany
    @JoinColumn(name = "product_id")
    private List<Product> products = new ArrayList<>();

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }
}
