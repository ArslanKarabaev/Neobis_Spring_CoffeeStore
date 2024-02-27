package com.example.Neobis_week_3.Dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CoffeeDto {

    private Long id;
    private String name;
    private Integer amount;
    private Integer price;

    public CoffeeDto(String name, Integer amount, Integer price) {
        this.name = name;
        this.amount = amount;
        this.price = price;
    }
}
