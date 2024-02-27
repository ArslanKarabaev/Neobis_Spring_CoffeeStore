package com.example.Neobis_week_3.Service;

import com.example.Neobis_week_3.Entity.Coffee;
import com.example.Neobis_week_3.Repository.CoffeeRepository;
import com.example.Neobis_week_3.Utils.CoffeeMappingUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CoffeeService {

    private final CoffeeRepository coffeeRepository;

    @Autowired
    public CoffeeService(CoffeeRepository coffeeRepository) {
        this.coffeeRepository = coffeeRepository;
    }

    public List<Coffee> getAllCoffee() {
        return coffeeRepository.findAll();
    }

    public Optional<Coffee> getCoffeeById(Long coffee_id) {
        boolean exists = coffeeRepository.existsById(coffee_id);
        if (!exists) {
            throw new IllegalStateException("There is no coffee with id " + coffee_id);
        }
        return coffeeRepository.findById(coffee_id);
    }


}
