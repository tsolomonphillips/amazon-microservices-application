package com.solstice.amazon.microservice.shipment.service;

import com.solstice.amazon.microservice.shipment.model.*;
import com.solstice.amazon.microservice.shipment.respository.ShipmentRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service
public class ShipmentService
{
    private ShipmentRepository shipmentRepository;
    private RestTemplate restTemplate;

    public ShipmentService(ShipmentRepository shipmentRepository, RestTemplate restTemplate)
    {
        this.shipmentRepository = shipmentRepository;
        this.restTemplate = restTemplate;
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

    public List<Shipment> getShipmentsByAccountId(Integer accountId)
    {
        return shipmentRepository.findAllByAccountIdOrderByDeliveryDateDesc(accountId);
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

    public List<ShipmentDetail> getShipmentDetails(Integer accountId)
    {
        List<ShipmentDetail> shipmentDetailList = new ArrayList<>();

        for (Shipment shipment : shipmentRepository.findAllByAccountIdOrderByDeliveryDateDesc(accountId))
        {
            ShipmentDetail shipmentDetail = new ShipmentDetail();

            shipmentDetail.setShipmentDate(shipment.getShippedDate());
            shipmentDetail.setDeliveryDate(shipment.getDeliveryDate());

            Order[] orderList = restTemplate.getForObject("http://order-orderline/orders", Order[].class);

            for (Order order : orderList)
            {
                OrderLine[] orderLine = restTemplate.getForObject
                        ("http://order-orderline/orders/" + order.getOrderId() + "/lines", OrderLine[].class);

//                if (shipment.getOrderLineId() == orderLine.getOrderLineId())
//                {
                    //order = restTemplate.getForObject("http://order-orderline/orders", Order.class);
                    shipmentDetail.setOrderNumber(order.getOrderNumber());
                //}
            }

            shipmentDetailList.add(shipmentDetail);

        }

        return shipmentDetailList;
    }

}
