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
    private Integer addressId;
    private Integer orderLineId;

    @Temporal(TemporalType.DATE)
    @JsonFormat(pattern = "MM-dd-yyyy")
    private Date shppedDate;

    @Temporal(TemporalType.DATE)
    @JsonFormat(pattern = "MM-dd-yyyy")
    private Date deliveryDate;

    public Shipment()
    {

    }

    public Shipment(Integer shipmentId, Integer accountId, Integer addressId,
                    Integer orderLineId, Date shppedDate, Date deliveryDate)
    {
        this.shipmentId = shipmentId;
        this.accountId = accountId;
        this.addressId = addressId;
        this.orderLineId = orderLineId;
        this.shppedDate = shppedDate;
        this.deliveryDate = deliveryDate;
    }

    public Integer getShipmentId()
    {
        return shipmentId;
    }

    public Integer getAccountId()
    {
        return accountId;
    }

    public void setAccountId(Integer accountId)
    {
        this.accountId = accountId;
    }

    public Integer getAddressId()
    {
        return addressId;
    }

    public void setAddressId(Integer addressId)
    {
        this.addressId = addressId;
    }

    public Integer getOrderLineId()
    {
        return orderLineId;
    }

    public void setOrderLineId(Integer orderLineId)
    {
        this.orderLineId = orderLineId;
    }

    public Date getShppedDate()
    {
        return shppedDate;
    }

    public void setShppedDate(Date shppedDate)
    {
        this.shppedDate = shppedDate;
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
