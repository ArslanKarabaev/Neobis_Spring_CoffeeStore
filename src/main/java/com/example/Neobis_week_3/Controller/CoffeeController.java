package com.example.Neobis_week_3.Controller;

import com.example.Neobis_week_3.Entity.Coffee;
import com.example.Neobis_week_3.Service.CoffeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "api/v1/CoffeeStore/Coffee/")
public class CoffeeController {
    private final CoffeeService coffeeService;

    @Autowired
    public CoffeeController(CoffeeService coffeeService) {
        this.coffeeService = coffeeService;
    }

    @GetMapping(path = "getAllCoffee")
    public List<Coffee> getAllCoffee() {
        return coffeeService.getAllCoffee();
    }

    @GetMapping(path = "{coffee_id}")
    public Optional<Coffee> getCoffeeById(@PathVariable("coffee_id") Long coffee_id){
        return coffeeService.getCoffeeById(coffee_id);
    }

}
