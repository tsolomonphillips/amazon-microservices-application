package com.solstice.amazon.microservice.orderorderline.controller;

import com.solstice.amazon.microservice.orderorderline.model.OrderLine;
import com.solstice.amazon.microservice.orderorderline.service.OrderLineService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/orders/{id}/lines")
public class OrderLineController
{
    private OrderLineService orderLineService;

    public OrderLineController(OrderLineService orderLineService)
    {
        this.orderLineService = orderLineService;
    }

    @GetMapping("")
    public List<OrderLine> getAllOrderLines(@PathVariable Integer orderId)
    {
        return orderLineService.getAllOrderLineItems(orderId);
    }

    @PostMapping("")
    public OrderLine getOneOrderLine(@RequestBody OrderLine orderLine, @PathVariable Integer orderId,
                                     @PathVariable Integer shipmentId)
    {
        return orderLineService.addOrderLineItem(orderLine, orderId, shipmentId);
    }

    @PutMapping("")
    public ResponseEntity updateOrderLine(@PathVariable Integer orderLineId, @PathVariable Integer orderId,
                                          @RequestBody OrderLine orderLine)
    {
        orderLineService.updateOrderLine(orderLineId, orderId, orderLine);
        return new ResponseEntity(HttpStatus.CREATED);
    }

    @DeleteMapping("")
    public ResponseEntity deleteOrderLine(@PathVariable Integer orderLineId)
    {
        orderLineService.deleteOrderLine(orderLineId);
        return new ResponseEntity(HttpStatus.ACCEPTED);
    }
}
