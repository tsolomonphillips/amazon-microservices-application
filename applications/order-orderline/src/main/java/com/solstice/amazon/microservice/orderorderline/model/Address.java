package com.solstice.amazon.microservice.orderorderline.model;

public class Address
{
    private Integer addressId;
    private String street;
    private String aptBuilding;
    private String city;
    private String stateProvince;
    private String zipPostalCode;
    private String country;

    public Address()
    {

    }

    public Address(Integer addressId, String street, String aptBuilding,
                   String city, String stateProvince, String zipPostalCode, String country)
    {
        this.addressId = addressId;
        this.street = street;
        this.aptBuilding = aptBuilding;
        this.city = city;
        this.stateProvince = stateProvince;
        this.zipPostalCode = zipPostalCode;
        this.country = country;
    }

    public Integer getAddressId()
    {
        return addressId;
    }

    public void setAddressId(Integer addressId)
    {
        this.addressId = addressId;
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
}
