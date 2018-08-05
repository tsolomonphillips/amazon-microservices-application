package com.solstice.amazon.microservice.orderorderline.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.ArrayList;
import java.util.List;

public class OrderDetail
{
    private String orderNumber;
    private Address shippingAddress;
    private Double totalPrice;
    private List<Shipment> shipmentList = new ArrayList<>();
    private List<Order> orderList;
    private String productName;

    @JsonIgnoreProperties({"orderLineId", "productId", "price", "totalPrice"})
    private List<OrderLine> orderLineListItems = new ArrayList<>();

    public OrderDetail()
    {

    }

    public OrderDetail(String orderNumber, Address shippingAddress, Double totalPrice,
                       List<Shipment> shipmentList, List<Order> orderList,
                       List<OrderLine> orderLineListItems, String productName)
    {
        this.orderNumber = orderNumber;
        this.shippingAddress = shippingAddress;
        this.totalPrice = totalPrice;
        this.shipmentList = shipmentList;
        this.orderList = orderList;
        this.orderLineListItems = orderLineListItems;
        this.productName = productName;
    }

    public String getOrderNumber()
    {
        return orderNumber;
    }

    public void setOrderNumber(String orderNumber)
    {
        this.orderNumber = orderNumber;
    }

    public Address getShippingAddress()
    {
        return shippingAddress;
    }

    public void setShippingAddress(Address shippingAddress)
    {
        this.shippingAddress = shippingAddress;
    }

    public Double getTotalPrice()
    {
        return totalPrice;
    }

    public void setTotalPrice(Double totalPrice)
    {
        this.totalPrice = totalPrice;
    }

    public List<Shipment> getShipmentList()
    {
        return shipmentList;
    }

    public void setShipmentList(List<Shipment> shipmentList)
    {
        this.shipmentList = shipmentList;
    }

    public List<Order> getOrderList()
    {
        return orderList;
    }

    public void setOrderList(List<Order> orderList)
    {
        this.orderList = orderList;
    }

    public List<OrderLine> getOrderLineListItems()
    {
        return orderLineListItems;
    }

    public void setOrderLineListItems(List<OrderLine> orderLineListItems)
    {
        this.orderLineListItems = orderLineListItems;
    }

    public String getProductName()
    {
        return productName;
    }

    public void setProductName(String productName)
    {
        this.productName = productName;
    }
}
