package com.layer.customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

@Component
public interface CustomerRepo extends JpaRepository<Customer, Long>{
}
