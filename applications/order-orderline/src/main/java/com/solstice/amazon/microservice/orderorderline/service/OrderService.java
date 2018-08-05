package com.solstice.amazon.microservice.orderorderline.service;

import com.solstice.amazon.microservice.orderorderline.model.*;
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

    public OrderDetail getOrderDetailForAccount(Integer orderId, Integer addressId)
    {
        OrderDetail orderDetail = new OrderDetail();
        Iterable<Order> orderList = orderRepository.findAllByOrderId(orderId);

        for (Order order : orderList)
        {
            orderDetail.setOrderNumber(order.getOrderNumber());
            orderDetail.setTotalPrice(order.getTotalPrice());
        }

        Address address = restTemplate.getForObject("http://account-address/accounts/"
                + orderId + "/address/" + addressId, Address.class);

        orderDetail.setShippingAddress(address);

        // working on populating orderLine items

        Order order = orderRepository.getOne(orderId);

        for (OrderLine orderLine : orderLineRepository.findAll())
        {
            if (orderLine.getOrder().getOrderId() == order.getOrderId())
            {
                orderDetail.getOrderLineListItems().add(orderLine);
                Product product = restTemplate.getForObject
                        ("http://product/products/" + orderLine.getProductId(), Product.class);
                orderLine.setProductName(product.getName());


                Shipment shipment = restTemplate.getForObject
                        ("http://shipment/shipments/" + orderLine.getShipmentId(), Shipment.class);

                orderDetail.getShipmentList().add(shipment);

                shipment.getOrderLineItems().add(orderLine);
            }
        }

        return orderDetail;
    }
}
