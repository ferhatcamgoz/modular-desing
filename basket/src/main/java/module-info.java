module basket {
    requires org.apache.logging.log4j;
    requires spring.boot.autoconfigure;
    requires spring.boot;
    requires spring.context;
    requires product;
    requires spring.beans;
    requires spring.web;
    requires spring.data.jpa;
    requires jakarta.persistence;
    requires common;
    exports com.layer.basket.customer;
    exports com.layer.basket.model;
}
