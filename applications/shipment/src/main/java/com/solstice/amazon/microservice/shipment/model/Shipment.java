package com.solstice.amazon.microservice.shipment.model;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "shipment")
public class Shipment
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer shipmentId;

    private Integer accountId;
    private Integer shippingAddressId;
    private Integer orderLineId;

    @Temporal(TemporalType.DATE)
    @JsonFormat(pattern = "MM-dd-yyyy")
    private Date shippedDate;

    @Temporal(TemporalType.DATE)
    @JsonFormat(pattern = "MM-dd-yyyy")
    private Date deliveryDate;

    public Shipment()
    {

    }

    public Shipment(Integer shipmentId, Integer accountId, Integer shippingAddressId,
                    Integer orderLineId, Date shippedDate, Date deliveryDate)
    {
        this.shipmentId = shipmentId;
        this.accountId = accountId;
        this.shippingAddressId = shippingAddressId;
        this.orderLineId = orderLineId;
        this.shippedDate = shippedDate;
        this.deliveryDate = deliveryDate;
    }

    public Integer getShipmentId()
    {
        return shipmentId;
    }

    public void setShipmentId(Integer shipmentId)
    {
        this.shipmentId = shipmentId;
    }

    public Integer getAccountId()
    {
        return accountId;
    }

    public void setAccountId(Integer accountId)
    {
        this.accountId = accountId;
    }

    public Integer getShippingAddressId()
    {
        return shippingAddressId;
    }

    public void setShippingAddressId(Integer shippingAddressId)
    {
        this.shippingAddressId = shippingAddressId;
    }

    public Integer getOrderLineId()
    {
        return orderLineId;
    }

    public void setOrderLineId(Integer orderLineId)
    {
        this.orderLineId = orderLineId;
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
}
