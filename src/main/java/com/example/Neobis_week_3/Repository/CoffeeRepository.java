package com.example.Neobis_week_3.Repository;

import com.example.Neobis_week_3.Models.Coffee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CoffeeRepository extends JpaRepository<Coffee,Long> {

    @Query("SELECT c FROM Coffee c WHERE c.name = ?1")
    Optional<Coffee> findCoffeeByName(String name);
}
