package com.solstice.amazon.microservice.orderorderline.repository;

import com.solstice.amazon.microservice.orderorderline.model.Order;
import com.solstice.amazon.microservice.orderorderline.model.OrderLine;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderLineRepository extends JpaRepository<OrderLine, Integer>
{
    //List<Order> findByOrder(Order order);
    Integer findByShipmentId(Integer shipmentId);
    OrderLine findByProductId(Integer productId);
    OrderLine findByOrderLineId(Integer orderLineId);
    Order findByOrder(Order order);
}
