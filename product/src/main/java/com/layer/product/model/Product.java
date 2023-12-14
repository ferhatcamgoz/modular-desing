package com.layer.product.model;
import com.layer.common.BaseEntity;
import com.layer.product.basket.ProductDto;
import jakarta.persistence.*;


@Entity
public class Product extends BaseEntity {

    private String name;
    private String description;
    private Double price;
    private int stock;

    public Product(ProductDto product) {
        this.name = product.getName();
        this.description = product.getDescription();
        this.price = product.getPrice();
        this.stock = product.getStock();
    }

    public Product() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }
}
