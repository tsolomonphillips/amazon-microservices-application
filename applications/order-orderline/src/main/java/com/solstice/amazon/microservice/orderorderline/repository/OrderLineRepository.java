package com.solstice.amazon.microservice.orderorderline.repository;

import com.solstice.amazon.microservice.orderorderline.model.OrderLine;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderLineRepository extends JpaRepository<OrderLine, Integer>
{

}
