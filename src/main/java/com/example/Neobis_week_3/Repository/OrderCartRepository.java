package com.example.Neobis_week_3.Repository;

import com.example.Neobis_week_3.Models.OrderCart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface OrderCartRepository extends JpaRepository<OrderCart, Long> {
    @Query("SELECT o FROM OrderCart o WHERE o.name = ?1")
    Optional<OrderCart> findOrderCartByName(String name);
}
