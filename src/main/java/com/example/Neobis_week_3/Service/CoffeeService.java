package com.example.Neobis_week_3.Service;

import com.example.Neobis_week_3.Models.Coffee;
import com.example.Neobis_week_3.Repository.CoffeeRepository;
import com.example.Neobis_week_3.Utils.CoffeeMappingUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CoffeeService {

    private final CoffeeRepository coffeeRepository;
    private final CoffeeMappingUtils coffeeMappingUtils;

    @Autowired
    public CoffeeService(CoffeeRepository coffeeRepository, CoffeeMappingUtils coffeeMappingUtils) {
        this.coffeeRepository = coffeeRepository;
        this.coffeeMappingUtils = coffeeMappingUtils;
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

    public void addNewCoffee(Coffee coffee) {
        Optional<Coffee> coffeeByName = coffeeRepository.findCoffeeByName(coffee.getName());
        if (coffeeByName.isPresent()) {
            throw new IllegalStateException("This coffee already added");
        }
        coffeeRepository.save(coffee);
    }

    public void deleteCoffee(Long coffee_id) {
        boolean exists = coffeeRepository.existsById(coffee_id);
        if (!exists) {
            throw new IllegalStateException("Coffee with id " + coffee_id + " does not exists");
        }
        coffeeRepository.deleteById(coffee_id);
    }


}
