package com.example.Neobis_week_3.Dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderCartDto {
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
