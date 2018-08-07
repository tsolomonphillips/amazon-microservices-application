package com.solstice.amazon.microservice.shipment.model;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Order
{
    private Integer orderId;
    private String orderNumber;
    private Double totalPrice;
    @Temporal(TemporalType.DATE)
    @JsonFormat(pattern = "MM-dd-yyyy")
    private Date orderDate;
    private Integer accountId;
    private Integer shippingAddressId;
    private List<OrderLine> orderLineList = new ArrayList<>();

    public Order()
    {

    }

    public Order(Integer orderId, String orderNumber, Double totalPrice, Date orderDate,
                 Integer accountId, Integer shippingAddressId, List<OrderLine> orderLineList)
    {
        this.orderId = orderId;
        this.orderNumber = orderNumber;
        this.totalPrice = totalPrice;
        this.orderDate = orderDate;
        this.accountId = accountId;
        this.shippingAddressId = shippingAddressId;
        this.orderLineList = orderLineList;
    }

    public Integer getOrderId()
    {
        return orderId;
    }

    public void setOrderId(Integer orderId)
    {
        this.orderId = orderId;
    }

    public String getOrderNumber()
    {
        return orderNumber;
    }

    public void setOrderNumber(String orderNumber)
    {
        this.orderNumber = orderNumber;
    }

    public Double getTotalPrice()
    {
        return totalPrice;
    }

    public void setTotalPrice(Double totalPrice)
    {
        this.totalPrice = totalPrice;
    }

    public Date getOrderDate()
    {
        return orderDate;
    }

    public void setOrderDate(Date orderDate)
    {
        this.orderDate = orderDate;
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

    public List<OrderLine> getOrderLineList()
    {
        return orderLineList;
    }

    public void setOrderLineList(List<OrderLine> orderLineList)
    {
        this.orderLineList = orderLineList;
    }
}
