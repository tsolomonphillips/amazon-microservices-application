package com.solstice.amazon.microservice.orderorderline.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import javax.persistence.*;

@Entity
@Table(name = "orderLine")
public class OrderLine
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer orderLineId;

    private Integer productId;
    private Integer quantity;
    private Double price;
    private Double totalPrice;
    private Integer shipmentId;
    private String productName;

    @ManyToOne
    @JsonBackReference
    private Order order;

    public OrderLine()
    {

    }

    public OrderLine(Integer orderLineId, Integer productId, Integer quantity,
                     Double price, Integer shipmentId, Order order, String productName)
    {
        this.orderLineId = orderLineId;
        this.productId = productId;
        this.quantity = quantity;
        this.price = price;
        this.shipmentId = shipmentId;
        this.productName = productName;
    }

    public Integer getOrderLineId()
    {
        return orderLineId;
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

    public void setTotalPrice(Double totalPrice)
    {
        this.totalPrice = quantity * price;
    }

    public Double getTotalPrice()
    {
        return totalPrice;
    }

    public Integer getShipmentId()
    {
        return shipmentId;
    }

    public void setShipmentId(Integer shipmentId)
    {
        this.shipmentId = shipmentId;
    }

    public Order getOrder()
    {
        return order;
    }

    public void setOrder(Order order)
    {
        this.order = order;
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
