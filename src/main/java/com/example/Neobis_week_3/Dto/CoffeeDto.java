package com.example.Neobis_week_3.Dto;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class CoffeeDto {
    @Id
    @SequenceGenerator(name = "CoffeeDto_sequence",
            sequenceName = "CoffeeDto_sequence",
            allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
            generator = "CoffeeDto_sequence")
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
