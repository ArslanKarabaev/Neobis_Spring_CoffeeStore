package com.example.Neobis_week_3.Utils;

import com.example.Neobis_week_3.Dto.CoffeeDto;
import com.example.Neobis_week_3.Models.Coffee;
import org.springframework.stereotype.Service;

@Service
public class CoffeeMappingUtils {
    public CoffeeDto mapToCoffeeDto(Coffee coffee){
        CoffeeDto coffeeDto = new CoffeeDto();
        coffeeDto.setId(coffee.getCoffee_id());
        coffeeDto.setName(coffee.getName());
        coffeeDto.setAmount(coffee.getAmount());
        coffeeDto.setPrice(coffee.getPrice());
        return coffeeDto;
    }

    public Coffee mapToCoffee(CoffeeDto coffeeDto){
        Coffee coffee = new Coffee();
        coffee.setCoffee_id(coffeeDto.getId());
        coffee.setName(coffeeDto.getName());
        coffee.setAmount(coffeeDto.getAmount());
        coffee.setPrice(coffeeDto.getPrice());
        return coffee;
    }
}
