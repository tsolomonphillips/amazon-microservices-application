package com.solstice.amazon.microservice.shipment.model;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.Date;
import java.util.List;

public class ShipmentDetail
{
    private String orderNumber;

    @Temporal(TemporalType.DATE)
    @JsonFormat(pattern = "MM-dd-yyyy")
    private Date shipmentDate;

    @Temporal(TemporalType.DATE)
    @JsonFormat(pattern = "MM-dd-yyyy")
    private Date deliveryDate;
    private List<OrderLine> orderLineList;
    private String productName;
    private Integer quantity;

    public ShipmentDetail()
    {

    }

    public ShipmentDetail(String orderNumber, Date shipmentDate, Date deliveryDate,
                          List<OrderLine> orderLineList, String productName, Integer quantity)
    {
        this.orderNumber = orderNumber;
        this.shipmentDate = shipmentDate;
        this.deliveryDate = deliveryDate;
        this.orderLineList = orderLineList;
        this.productName = productName;
        this.quantity = quantity;
    }

    public String getOrderNumber()
    {
        return orderNumber;
    }

    public void setOrderNumber(String orderNumber)
    {
        this.orderNumber = orderNumber;
    }

    public Date getShipmentDate()
    {
        return shipmentDate;
    }

    public void setShipmentDate(Date shipmentDate)
    {
        this.shipmentDate = shipmentDate;
    }

    public Date getDeliveryDate()
    {
        return deliveryDate;
    }

    public void setDeliveryDate(Date deliveryDate)
    {
        this.deliveryDate = deliveryDate;
    }

    public List<OrderLine> getOrderLineList()
    {
        return orderLineList;
    }

    public void setOrderLineList(List<OrderLine> orderLineList)
    {
        this.orderLineList = orderLineList;
    }

    public String getProductName()
    {
        return productName;
    }

    public void setProductName(String productName)
    {
        this.productName = productName;
    }

    public Integer getQuantity()
    {
        return quantity;
    }

    public void setQuantity(Integer quantity)
    {
        this.quantity = quantity;
    }
}
