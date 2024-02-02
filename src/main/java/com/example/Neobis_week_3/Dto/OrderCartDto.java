package com.example.Neobis_week_3.Dto;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class OrderCartDto {
    @Id
    @SequenceGenerator(name = "OrderCartDtoSequence",
            sequenceName = "OrderCartDtoSequence",
            allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
            generator = "OrderCartDtoSequence")
    private Long orderId;
    private String name;
    private Integer amount;
    private Integer sum;
    private Integer sumOfCart;

    public OrderCartDto(String name, Integer amount, Integer sum, Integer sumOfCart) {
        this.name = name;
        this.amount = amount;
        this.sum = sum;
        this.sumOfCart = sumOfCart;
    }
}
