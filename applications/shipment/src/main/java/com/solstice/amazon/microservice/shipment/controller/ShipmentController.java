package com.solstice.amazon.microservice.shipment.controller;

import com.solstice.amazon.microservice.shipment.model.Shipment;
import com.solstice.amazon.microservice.shipment.service.ShipmentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/shipments")
public class ShipmentController
{
    private ShipmentService shipmentService;

    public ShipmentController(ShipmentService shipmentService)
    {
        this.shipmentService = shipmentService;
    }

    @GetMapping("")
    public List<Shipment> getAllShipments()
    {
        return shipmentService.getAllShipments();
    }

    @GetMapping("/{shipmentId}")
    public Shipment getOneShipment(@PathVariable Integer shipmentId)
    {
        return shipmentService.getOneShipment(shipmentId);
    }

    @PostMapping("")
    public ResponseEntity addShipment(Shipment shipment)
    {
        shipmentService.addShipment(shipment);
        return new ResponseEntity(HttpStatus.CREATED);
    }

    @PutMapping("/{shipmentId}")
    public ResponseEntity updateShipment(@PathVariable Integer shipmentId, @RequestBody Shipment shipment)
    {
        shipmentService.updateShipment(shipmentId, shipment);
        return new ResponseEntity(HttpStatus.CREATED);
    }

    @DeleteMapping("/{shipmentId}")
    public ResponseEntity deleteShipment(@PathVariable Integer shipmentId)
    {
        shipmentService.deleteShipment(shipmentId);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }
}
