package com.example.Neobis_week_3.Service;

import com.example.Neobis_week_3.Dto.CoffeeDto;
import com.example.Neobis_week_3.Entity.Coffee;
import com.example.Neobis_week_3.Repository.CoffeeRepository;
import com.example.Neobis_week_3.Utils.CoffeeMappingUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CoffeeService {

    private final CoffeeRepository coffeeRepository;
    private final CoffeeMappingUtils coffeeMappingUtils;

    public List<Coffee> getAllCoffee() {
        return coffeeRepository.findAll();
    }
    public List<CoffeeDto> getAllCoffeeDto(){return getAllCoffee().stream().map(coffeeMappingUtils::mapToCoffeeDto).collect(Collectors.toList());}

    public Optional<Coffee> getCoffeeById(Long coffee_id) {
        boolean exists = coffeeRepository.existsById(coffee_id);
        if (!exists) {
            throw new IllegalStateException("There is no coffee with id " + coffee_id);
        }
        return coffeeRepository.findById(coffee_id);
    }
    public Optional<CoffeeDto> getCoffeeByIdDto(Long coffee_id){
        return getCoffeeById(coffee_id).map(coffeeMappingUtils::mapToCoffeeDto);
    }


}
