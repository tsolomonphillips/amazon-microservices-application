package com.solstice.amazon.microservice.orderorderline.repository;

import com.solstice.amazon.microservice.orderorderline.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<Order, Integer>
{
    List<Order> findAllByAccountIdOrderByOrderDateDesc(Integer accountId);
    List<Order> findAllByShippingAddressIdOrderByOrderDateDesc(Integer accountId);
}
