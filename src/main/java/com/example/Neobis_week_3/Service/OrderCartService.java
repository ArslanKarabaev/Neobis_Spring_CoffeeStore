package com.example.Neobis_week_3.Service;

import com.example.Neobis_week_3.Dto.OrderCartDto;
import com.example.Neobis_week_3.Entity.OrderCart;
import com.example.Neobis_week_3.Repository.OrderCartRepository;
import com.example.Neobis_week_3.Utils.OrderCartMappingUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class OrderCartService {
    private final OrderCartRepository orderCartRepository;
    private final OrderCartMappingUtils orderCartMappingUtils;

    @Autowired
    public OrderCartService(OrderCartRepository orderCartRepository, OrderCartMappingUtils orderCartMappingUtils) {
        this.orderCartRepository = orderCartRepository;
        this.orderCartMappingUtils = orderCartMappingUtils;
    }

    public List<OrderCart> getAllOrders() {
        return orderCartRepository.findAll();
    }
    public List<OrderCartDto> getAllOrdersDto(){return getAllOrders().stream().map(orderCartMappingUtils::MapToOrderCartDto).collect(Collectors.toList());}

    public void addNewOrder(OrderCart orderCart) {
        orderCartRepository.save(orderCart);
    }

    public void deleteOrder(Long orderID) {
        boolean exists = orderCartRepository.existsById(orderID);
        if (!exists) {
            throw new IllegalStateException("Order with id " + orderID + " does not exists");
        }
        orderCartRepository.deleteById(orderID);
    }

}
