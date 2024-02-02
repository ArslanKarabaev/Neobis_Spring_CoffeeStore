package com.example.Neobis_week_3.Models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table
public class Coffee {
    @Id
    @SequenceGenerator(name = "Coffee_sequence",
    sequenceName = "Coffee_sequence",
    allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
    generator = "Coffee_sequence")
    private Long coffee_id;
    private String name;
    private Integer amount;
    private Integer price;

    public Coffee(String name, Integer amount, Integer price) {
        this.name = name;
        this.amount = amount;
        this.price = price;
    }
}
