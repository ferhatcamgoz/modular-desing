
module product {
    requires spring.boot.autoconfigure;
    requires spring.boot;
    requires spring.context;
    requires jakarta.persistence;
    requires common;
    requires spring.web;
    requires spring.data.jpa;
    exports com.layer.product.basket to basket;
    exports com.layer.product.model to basket;
}
