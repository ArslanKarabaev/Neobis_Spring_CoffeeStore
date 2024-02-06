package com.example.Neobis_week_3.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table
public class OrderCart {
    @Id
    @SequenceGenerator(name = "OrderCartSequence",
            sequenceName = "OrderCartSequence",
            allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
            generator = "OrderCartSequence")
    private Long orderId;
    private String name;
    private Integer amount;
    private Integer sum;
    private Integer sumOfCart;

    public OrderCart(String name, Integer amount, Integer sum, Integer sumOfCart) {
        this.name = name;
        this.amount = amount;
        this.sum = sum;
        this.sumOfCart = sumOfCart;
    }
}
