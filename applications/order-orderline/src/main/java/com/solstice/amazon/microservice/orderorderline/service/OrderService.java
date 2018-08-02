package com.solstice.amazon.microservice.orderorderline.service;

import com.solstice.amazon.microservice.orderorderline.model.Address;
import com.solstice.amazon.microservice.orderorderline.model.Order;
import com.solstice.amazon.microservice.orderorderline.model.OrderDetail;
import com.solstice.amazon.microservice.orderorderline.repository.OrderLineRepository;
import com.solstice.amazon.microservice.orderorderline.repository.OrderRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class OrderService
{
    private OrderRepository orderRepository;
    private OrderLineRepository orderLineRepository;
    private RestTemplate restTemplate;

    public OrderService(OrderRepository orderRepository,
                        OrderLineRepository orderLineRepository, RestTemplate restTemplate)
    {
        this.orderRepository = orderRepository;
        this.orderLineRepository = orderLineRepository;
        this.restTemplate = restTemplate;
    }

    public Order addOrder(Order order)
    {
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
        orderToUpdate.setShippingAddressId(order.getShippingAddressId());
        orderToUpdate.setOrderNumber(order.getOrderNumber());
        orderToUpdate.setAccountId(order.getAccountId());
        orderToUpdate.setTotalPrice(order.getTotalPrice());
        orderRepository.save(orderToUpdate);

        return new ResponseEntity(HttpStatus.CREATED);
    }

    public ResponseEntity deleteOrder(Integer orderId)
    {
        orderRepository.deleteById(orderId);
        return new ResponseEntity(HttpStatus.ACCEPTED);
    }

    public List<Order> getAllOrdersForAccount(Integer accountId)
    {
        return orderRepository.findAllByAccountIdOrderByOrderDateDesc(accountId);
    }

    public OrderDetail getOrderDetailForAccount(Integer accountId)
    {
        OrderDetail orderDetail = new OrderDetail();

        Address address = restTemplate.getForObject("http://account-address/accounts/"
                + accountId + "/address", Address.class);

        for (Order order : orderRepository.findAll())
        {
            if (order.getAccountId() == accountId)
            {
                orderDetail.setOrderNumber(order.getOrderNumber());
                orderDetail.setTotalPrice(order.getTotalPrice());
            }
        }

        for (Order order : orderRepository.findAll())
        {
            if (order.getShippingAddressId() == address.getAddressId())
            {
                orderDetail.getAddressList().add(address);
            }
        }

        // get shipment

        return orderDetail;
    }
}
