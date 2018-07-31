package com.solstice.amazon.microservice.shipment.respository;

import com.solstice.amazon.microservice.shipment.model.Shipment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ShipmentRepository extends JpaRepository<Shipment, Integer>
{

}
