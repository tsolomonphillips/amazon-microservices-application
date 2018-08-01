package com.solstice.amazon.microservice.shipment.service;

import com.solstice.amazon.microservice.shipment.model.Shipment;
import com.solstice.amazon.microservice.shipment.respository.ShipmentRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShipmentService
{
    private ShipmentRepository shipmentRepository;

    public ShipmentService(ShipmentRepository shipmentRepository)
    {
        this.shipmentRepository = shipmentRepository;
    }

    public ResponseEntity addShipment(Shipment shipment)
    {
        shipmentRepository.save(shipment);
        return new ResponseEntity(HttpStatus.CREATED);
    }

    public List<Shipment> getAllShipments()
    {
        return shipmentRepository.findAll();
    }

    public Shipment getOneShipment(Integer shipmentId)
    {
        Shipment shipment = shipmentRepository.getOne(shipmentId);
        return shipment;
    }

    public ResponseEntity updateShipment(Integer shipmentId, Shipment shipment)
    {
        Shipment shipmentToUpdate = shipmentRepository.getOne(shipmentId);

        shipmentToUpdate.setDeliveryDate(shipment.getDeliveryDate());
        shipmentToUpdate.setOrderLineId(shipment.getOrderLineId());
        shipmentToUpdate.setShippingAddressId(shipment.getShippingAddressId());
        shipmentToUpdate.setShippedDate(shipment.getShippedDate());

        shipmentRepository.save(shipmentToUpdate);
        return new ResponseEntity(HttpStatus.CREATED);
    }

    public ResponseEntity deleteShipment(Integer shipmentId)
    {
        shipmentRepository.deleteById(shipmentId);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }


}
