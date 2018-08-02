package com.solstice.amazon.microservice.orderorderline.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

public class OrderDetail
{
    private String orderNumber;
    private List<Address> addressList;
    private Double totalPrice;

    @JsonIgnoreProperties({"orderLineId, price, shipmentId"})
    private List<OrderLine> orderLineListItems;

    public OrderDetail()
    {

    }

    public OrderDetail(String orderNumber, List<Address> addressList,
                       Double totalPrice, List<OrderLine> orderLineListItems)
    {
        this.orderNumber = orderNumber;
        this.addressList = addressList;
        this.totalPrice = totalPrice;
        this.orderLineListItems = orderLineListItems;
    }

    public String getOrderNumber()
    {
        return orderNumber;
    }

    public void setOrderNumber(String orderNumber)
    {
        this.orderNumber = orderNumber;
    }

    public List<Address> getAddressList()
    {
        return addressList;
    }

    public void setAddressList(List<Address> addressList)
    {
        this.addressList = addressList;
    }

    public Double getTotalPrice()
    {
        return totalPrice;
    }

    public void setTotalPrice(Double totalPrice)
    {
        this.totalPrice = totalPrice;
    }

    public List<OrderLine> getOrderLineListItems()
    {
        return orderLineListItems;
    }

    public void setOrderLineListItems(List<OrderLine> orderLineListItems)
    {
        this.orderLineListItems = orderLineListItems;
    }
}
