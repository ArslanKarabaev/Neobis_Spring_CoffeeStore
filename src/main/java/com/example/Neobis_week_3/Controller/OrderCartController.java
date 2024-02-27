package com.example.Neobis_week_3.Controller;

import com.example.Neobis_week_3.Entity.OrderCart;
import com.example.Neobis_week_3.Service.OrderCartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/CoffeeStore/Order/Cart")
public class OrderCartController {
    private final OrderCartService orderCartService;

    @Autowired
    public OrderCartController(OrderCartService orderCartService) {
        this.orderCartService = orderCartService;
    }

    @GetMapping
    public List<OrderCart> getAllOrders() {
        return orderCartService.getAllOrders();
    }

    @PostMapping
    public void addNewOrder(@RequestBody OrderCart order) {
        orderCartService.addNewOrder(order);
    }

    @DeleteMapping(path = "{orderId}")
    public void deleteOrder(@PathVariable("orderId") Long orderId) {
        orderCartService.deleteOrder(orderId);
    }

}
