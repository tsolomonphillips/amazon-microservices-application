package com.solstice.amazon.microservice.orderorderline.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

public class OrderDetail
{
    private String orderNumber;
    private String street;
    private String aptBuilding;
    private String city;
    private String stateProvince;
    private String zipPostalCode;
    private String country;
    private Double totalPrice;

    @JsonIgnoreProperties({"orderLineId, price, shipmentId"})
    private List<OrderLine> orderLineListItems;

    public OrderDetail()
    {

    }

    public OrderDetail(String orderNumber, String street, String aptBuilding, String city, String stateProvince,
                       String zipPostalCode, String country, Double totalPrice, List<OrderLine> orderLineListItems)
    {
        this.orderNumber = orderNumber;
        this.street = street;
        this.aptBuilding = aptBuilding;
        this.city = city;
        this.stateProvince = stateProvince;
        this.zipPostalCode = zipPostalCode;
        this.country = country;
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

    public String getStreet()
    {
        return street;
    }

    public void setStreet(String street)
    {
        this.street = street;
    }

    public String getAptBuilding()
    {
        return aptBuilding;
    }

    public void setAptBuilding(String aptBuilding)
    {
        this.aptBuilding = aptBuilding;
    }

    public String getCity()
    {
        return city;
    }

    public void setCity(String city)
    {
        this.city = city;
    }

    public String getStateProvince()
    {
        return stateProvince;
    }

    public void setStateProvince(String stateProvince)
    {
        this.stateProvince = stateProvince;
    }

    public String getZipPostalCode()
    {
        return zipPostalCode;
    }

    public void setZipPostalCode(String zipPostalCode)
    {
        this.zipPostalCode = zipPostalCode;
    }

    public String getCountry()
    {
        return country;
    }

    public void setCountry(String country)
    {
        this.country = country;
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
