package com.example.Neobis_week_3.Service;

import com.example.Neobis_week_3.Entity.OrderCart;
import com.example.Neobis_week_3.Repository.OrderCartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderCartService {
    public final OrderCartRepository orderCartRepository;

    @Autowired
    public OrderCartService(OrderCartRepository orderCartRepository) {
        this.orderCartRepository = orderCartRepository;
    }

    public List<OrderCart> getAllOrders() {
        return orderCartRepository.findAll();
    }

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
