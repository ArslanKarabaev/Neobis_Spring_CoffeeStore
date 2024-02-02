package com.example.Neobis_week_3.Utils;

import com.example.Neobis_week_3.Dto.OrderCartDto;
import com.example.Neobis_week_3.Models.OrderCart;
import org.springframework.stereotype.Service;

@Service
public class OrderCartMappingUtils {
    public OrderCartDto MapToOrderCartDto(OrderCart orderCart) {
        OrderCartDto orderCartDto = new OrderCartDto();
        orderCartDto.setOrderId(orderCart.getOrderId());
        orderCartDto.setName(orderCart.getName());
        orderCartDto.setAmount(orderCart.getAmount());
        orderCartDto.setSum(orderCart.getSum());
        orderCartDto.setSumOfCart(orderCart.getSumOfCart());
        return orderCartDto;
    }

    public OrderCart MapToOrderCart(OrderCartDto orderCartDto) {
        OrderCart orderCart = new OrderCart();
        orderCart.setOrderId(orderCartDto.getOrderId());
        orderCart.setName(orderCartDto.getName());
        orderCart.setAmount(orderCartDto.getAmount());
        orderCart.setSum(orderCartDto.getSum());
        orderCart.setSumOfCart(orderCartDto.getSumOfCart());
        return orderCart;
    }
}
