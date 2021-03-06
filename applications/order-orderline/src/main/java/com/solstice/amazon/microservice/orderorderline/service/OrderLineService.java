package com.solstice.amazon.microservice.orderorderline.service;

import com.solstice.amazon.microservice.orderorderline.model.Order;
import com.solstice.amazon.microservice.orderorderline.model.OrderLine;
import com.solstice.amazon.microservice.orderorderline.repository.OrderLineRepository;
import com.solstice.amazon.microservice.orderorderline.repository.OrderRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class OrderLineService
{
    private OrderLineRepository orderLineRepository;
    private OrderRepository orderRepository;

    public OrderLineService(OrderLineRepository orderLineRepository, OrderRepository orderRepository)
    {
        this.orderLineRepository = orderLineRepository;
        this.orderRepository = orderRepository;
    }

    public OrderLine addOrderLineItem(OrderLine orderLine, Integer orderId)
    {
        Order order = orderRepository.getOne(orderId);

        orderLine.setOrder(order);
        orderLine.setShipmentId(orderLine.getShipmentId());
        orderLine.setTotalPrice(orderLine.getTotalPrice());

        order.getOrderLineList().add(orderLine);

        return orderLineRepository.save(orderLine);
    }

    public List<OrderLine> getAllOrderLineItems(Integer orderId)
    {
        List<OrderLine> orderLineList = orderLineRepository.findAll();
        List<OrderLine> newOrderLineList = new ArrayList<>();

        for (OrderLine orderLine : orderLineList)
        {
            if (orderLine.getOrder().getOrderId() == orderId)
            {
                newOrderLineList.add(orderLine);
            }
        }

        return newOrderLineList;
    }

    public ResponseEntity updateOrderLine(Integer orderLineId, Integer orderId, OrderLine orderLine)
    {
        OrderLine orderLineToUpdate = orderLineRepository.getOne(orderLineId);
        orderLineToUpdate.setQuantity(orderLine.getQuantity());
        orderLineToUpdate.setPrice(orderLine.getPrice());
        orderLineToUpdate.setShipmentId(orderLine.getShipmentId());
        orderLineToUpdate.setProductId(orderLine.getProductId());

        Order order = orderRepository.getOne(orderId);
        orderLineToUpdate.setOrder(order);

        return new ResponseEntity(HttpStatus.CREATED);
    }

    public ResponseEntity deleteOrderLine(Integer orderLineId)
    {
        orderLineRepository.deleteById(orderLineId);
        return new ResponseEntity(HttpStatus.ACCEPTED);
    }

    public OrderRepository getOrderRepository()
    {
        return this.orderRepository;
    }
}
