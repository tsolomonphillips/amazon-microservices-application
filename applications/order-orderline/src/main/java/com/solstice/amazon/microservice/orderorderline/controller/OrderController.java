package com.solstice.amazon.microservice.orderorderline.controller;

import com.solstice.amazon.microservice.orderorderline.model.Order;
import com.solstice.amazon.microservice.orderorderline.service.OrderService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/orders")
public class OrderController
{
    private OrderService orderService;

    public OrderController(OrderService orderService)
    {
        this.orderService = orderService;
    }

    @PostMapping("")
    public Order addOrder(@RequestBody Order order, @PathVariable Integer accountId,
                          @PathVariable Integer shippingAddress)
    {
        return orderService.addOrder(order, accountId, shippingAddress);
    }

    @GetMapping("")
    public List<Order> getAllOrders()
    {
        return orderService.getAllOrders();
    }

    @GetMapping("/{orderId}")
    public Order getOneOrder(@PathVariable Integer orderId)
    {
        return orderService.getOneOrder(orderId);
    }

    @PutMapping("/{orderId}")
    public ResponseEntity updateOrder(@PathVariable Integer orderId, @RequestBody Order order)
    {
        orderService.updateOrder(orderId, order);
        return new ResponseEntity(HttpStatus.CREATED);
    }

    @DeleteMapping("/{orderId}")
    public ResponseEntity deleteOrder(@PathVariable Integer orderId)
    {
        orderService.deleteOrder(orderId);
        return new ResponseEntity(HttpStatus.ACCEPTED);
    }
}
