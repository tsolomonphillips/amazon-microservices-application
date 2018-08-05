package com.solstice.amazon.microservice.orderorderline.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Shipment
{
    private Integer shipmentId;

    @Temporal(TemporalType.DATE)
    @JsonFormat(pattern = "MM-dd-yyyy")
    private Date shippedDate;

    @Temporal(TemporalType.DATE)
    @JsonFormat(pattern = "MM-dd-yyyy")
    private Date deliveryDate;

    @JsonIgnoreProperties({"productId", "quantity", "price", "totalPrice", "shipmentId", "productName"})
    private List<OrderLine> orderLineItems = new ArrayList<>();

    public Shipment()
    {

    }

    public Shipment(Integer shipmentId, Date shippedDate, Date deliveryDate,
                    List<OrderLine> orderLineItems)
    {
        this.shipmentId = shipmentId;
        this.shippedDate = shippedDate;
        this.deliveryDate = deliveryDate;
        this.orderLineItems = orderLineItems;
    }

    public Integer getShipmentId()
    {
        return shipmentId;
    }

    public void setShipmentId(Integer shipmentId)
    {
        this.shipmentId = shipmentId;
    }

    public Date getShippedDate()
    {
        return shippedDate;
    }

    public void setShippedDate(Date shippedDate)
    {
        this.shippedDate = shippedDate;
    }

    public Date getDeliveryDate()
    {
        return deliveryDate;
    }

    public void setDeliveryDate(Date deliveryDate)
    {
        this.deliveryDate = deliveryDate;
    }

    public List<OrderLine> getOrderLineItems()
    {
        return orderLineItems;
    }

    public void setOrderLineItems(List<OrderLine> orderLineItems)
    {
        this.orderLineItems = orderLineItems;
    }
}
