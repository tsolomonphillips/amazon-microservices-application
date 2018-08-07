package com.solstice.amazon.microservice.shipment.respository;

import com.solstice.amazon.microservice.shipment.model.Shipment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ShipmentRepository extends JpaRepository<Shipment, Integer>
{
    List<Shipment> findAllByAccountIdOrderByDeliveryDateDesc(Integer accountId);
    Shipment findByShipmentId(Integer shipmentId);
    Shipment findByOrderLineId(Integer orderLineId);
    Shipment findByShippingAddressId(Integer shippingAddressId);
}
