package com.solstice.amazon.microservice.accountaddress.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "accountaddressdb")
public class Account
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "account_id")
    private final Integer accountId;

    private String firstName;
    private String lastName;
    private String emailAddress;

    @OneToMany
    @JoinColumn(name = "address_Id")
    private List<Address> addressList;

    public Account(Integer accountId)
    {
        this.accountId = accountId;
    }

    public Account(Integer accountId, String firstName, String lastName,
                   String emailAddress)
    {
        this.accountId = accountId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.emailAddress = emailAddress;
        this.addressList = new ArrayList<>();
    }

    public int getAccountId()
    {
        return accountId;
    }

    public String getFirstName()
    {
        return firstName;
    }

    public void setFirstName(String firstName)
    {
        this.firstName = firstName;
    }

    public String getLastName()
    {
        return lastName;
    }

    public void setLastName(String lastName)
    {
        this.lastName = lastName;
    }

    public String getEmailAddress()
    {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress)
    {
        this.emailAddress = emailAddress;
    }

    public List<Address> getAddressList()
    {
        return addressList;
    }

    public void setAddressList(List<Address> addressList)
    {
        this.addressList = addressList;
    }
}
