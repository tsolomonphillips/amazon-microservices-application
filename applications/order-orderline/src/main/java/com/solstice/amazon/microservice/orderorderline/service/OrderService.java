package com.solstice.amazon.microservice.orderorderline.service;

import com.solstice.amazon.microservice.orderorderline.model.Order;
import com.solstice.amazon.microservice.orderorderline.repository.OrderRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService
{
    private OrderRepository orderRepository;

    public OrderService(OrderRepository orderRepository)
    {
        this.orderRepository = orderRepository;
    }

    public Order addOrder(Order order, Integer accountId, Integer shippingAddressId)
    {
        order.setAccountId(accountId);
        order.setShippingAddress(shippingAddressId);

        return orderRepository.save(order);
    }

    public List<Order> getAllOrders()
    {
        return orderRepository.findAll();
    }

    public Order getOneOrder(Integer orderId)
    {
        return orderRepository.getOne(orderId);
    }

    public ResponseEntity updateOrder(Integer orderId, Order order)
    {
        Order orderToUpdate = orderRepository.getOne(orderId);
        orderToUpdate.setShippingAddress(order.getShippingAddressId());
        orderToUpdate.setOrderNumber(order.getOrderNumber());

        orderRepository.save(orderToUpdate);

        return new ResponseEntity(HttpStatus.CREATED);
    }

    public ResponseEntity deleteOrder(Integer orderId)
    {
        orderRepository.deleteById(orderId);
        return new ResponseEntity(HttpStatus.ACCEPTED);
    }
}
