package com.solstice.amazon.microservice.accountaddress.model;

import javax.persistence.*;

@Entity
@Table(name = "address")
public class Address
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "address_id")
    private Integer addressId;

    private String street;
    private String aptBuilding;
    private String city;
    private String stateProvince;
    private String zipPostalCode;
    private String country;

    @ManyToOne
    @JoinColumn(name = "account_id")
    private Account account;


    public Address()
    {

    }

    public Address(Integer addressId, String street, String aptBuilding,
                   String city, String stateProvince, String zipPostalCode,
                   String country, Account account)
    {
        this.addressId = addressId;
        this.street = street;
        this.aptBuilding = aptBuilding;
        this.city = city;
        this.zipPostalCode = zipPostalCode;
        this.country = country;
        this.account = account;
    }

    public Integer getAddressId()
    {
        return this.addressId;
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

    public void setAccount(Account account)
    {
        this.account = account;
    }

    public Account getAccount()
    {
        return account;
    }
}
