package com.layer.basket;
import com.layer.basket.model.Basket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Repository
@Component
public interface BasketRepo extends JpaRepository<Basket, Long>{

}
