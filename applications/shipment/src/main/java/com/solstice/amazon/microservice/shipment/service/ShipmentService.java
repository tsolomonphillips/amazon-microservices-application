package com.solstice.amazon.microservice.shipment.service;

import com.solstice.amazon.microservice.shipment.respository.ShipmentRepository;
import org.springframework.stereotype.Service;

@Service
public class ShipmentService
{
    private ShipmentRepository shipmentRepository;

    public ShipmentService(ShipmentRepository shipmentRepository)
    {
        this.shipmentRepository = shipmentRepository;
    }


}
