package com.solstice.amazon.microservice.shipment.model;

public class OrderLine
{
    private Integer orderLineId;
    private Integer productId;
    private Integer quantity;
    private Double price;
    private Double totalPrice;
    private Integer shipmentId;
    private String productName;
    private Order order;

    public OrderLine()
    {

    }

    public OrderLine(Integer orderLineId, Integer productId, Integer quantity,
                     Double price, Double totalPrice, Integer shipmentId, String productName, Order order)
    {
        this.orderLineId = orderLineId;
        this.productId = productId;
        this.quantity = quantity;
        this.price = price;
        this.totalPrice = totalPrice;
        this.shipmentId = shipmentId;
        this.productName = productName;
        this.order = order;
    }

    public Integer getOrderLineId()
    {
        return orderLineId;
    }

    public void setOrderLineId(Integer orderLineId)
    {
        this.orderLineId = orderLineId;
    }

    public Integer getProductId()
    {
        return productId;
    }

    public void setProductId(Integer productId)
    {
        this.productId = productId;
    }

    public Integer getQuantity()
    {
        return quantity;
    }

    public void setQuantity(Integer quantity)
    {
        this.quantity = quantity;
    }

    public Double getPrice()
    {
        return price;
    }

    public void setPrice(Double price)
    {
        this.price = price;
    }

    public Double getTotalPrice()
    {
        return totalPrice;
    }

    public void setTotalPrice(Double totalPrice)
    {
        this.totalPrice = totalPrice;
    }

    public Integer getShipmentId()
    {
        return shipmentId;
    }

    public void setShipmentId(Integer shipmentId)
    {
        this.shipmentId = shipmentId;
    }

    public String getProductName()
    {
        return productName;
    }

    public void setProductName(String productName)
    {
        this.productName = productName;
    }

    public Order getOrder()
    {
        return order;
    }

    public void setOrder(Order order)
    {
        this.order = order;
    }
}
