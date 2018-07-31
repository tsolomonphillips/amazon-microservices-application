package com.solstice.amazon.microservice.accountaddress.controller;

import com.solstice.amazon.microservice.accountaddress.model.Account;
import com.solstice.amazon.microservice.accountaddress.model.Address;
import com.solstice.amazon.microservice.accountaddress.service.AddressService;
import com.sun.org.apache.xerces.internal.parsers.SecurityConfiguration;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(AddressController.class)
@ContextConfiguration(classes = {SecurityConfiguration.class})
public class AddressControllerTest
{
    @Autowired
    private MockMvc mockMvc;

    @Mock
    private AddressService addressService;

    @InjectMocks
    private AddressController addressController;

    // TODO: 7/31/18 Add security configuration so tests pass (have been getting a 403 error code when running tests)  
    
    @Before
    public void setUp()
    {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void addAddress() throws Exception
    {
        Account account = new Account(1, "Lebron", "James",
                "lebron.james@gmail.com");

        Address address = new Address(1, "123", "Sunny Apartment", "New York",
                "NY", "12504", "U.S", account);

        when(addressService.addAddress(1, address)).thenReturn(new ResponseEntity(HttpStatus.CREATED));

        mockMvc.perform(post("/addresses")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andReturn();
    }

    @Test
    public void getAllAddresses() throws Exception
    {
        List<Address> addressList = new ArrayList<>();

        Account account1 = new Account(1, "Lebron", "James",
                "lebron.james@gmail.com");
        Account account2 = new Account(2, "Allen", "Iverson",
                "allen.iverson.com");
        Account account3 = new Account(3, "Kobe", "Bryant",
                "kobe.bryant@gmail.com");

        Address address1 = new Address(1, "123", "Sunny Apartment", "New York",
                "NY", "12504", "U.S", account1);
        Address address2 = new Address(1, "123", "Sunny Apartment", "New York",
                "NY", "12504", "U.S", account2);
        Address address3 = new Address(1, "123", "Sunny Apartment", "New York",
                "NY", "12504", "U.S", account3);


        addressList.add(address1);
        addressList.add(address2);
        addressList.add(address3);

        when(addressService.getAddressList()).thenReturn(addressList);

        mockMvc.perform(get("/addresses")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andReturn();

    }

    @Test
    public void getOneAddress() throws Exception
    {
        Account account1 = new Account(1, "Lebron", "James",
                "lebron.james@gmail.com");

        Address address1 = new Address(1, "123", "Sunny Apartment", "New York",
                "NY", "12504", "U.S", account1);

        when(addressService.getOneAddress(address1.getAddressId())).thenReturn(address1);

        mockMvc.perform(get("/addresses/1")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andReturn();


    }

    @Test
    public void updateAddress() throws Exception
    {
        Account account1 = new Account(1, "Lebron", "James",
                "lebron.james@gmail.com");

        Address addressToUpdate = new Address(1, "123", "Sunny Apartment", "New York",
                "NY", "12504", "U.S", account1);

        Address newAddressInformaiton = new Address(2, "456", "Solstice Apartments", "Chicago",
                "Illinois", "12345", "US", account1);

        when(addressService.updateAddress(addressToUpdate.getAddressId(), newAddressInformaiton))
                .thenReturn(new ResponseEntity(HttpStatus.ACCEPTED));

        mockMvc.perform(put("/addresses/1")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andReturn();
    }

    @Test
    public void deleteAddress() throws Exception
    {
        Account account1 = new Account(1, "Lebron", "James",
                "lebron.james@gmail.com");

        Address address = new Address(2, "456", "Solstice Apartments", "Chicago",
                "Illinois", "12345", "US", account1);

        when(addressService.deleteAddress(address.getAddressId()))
                .thenReturn(new ResponseEntity(HttpStatus.ACCEPTED));

        mockMvc.perform(delete("/addresses/1")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andReturn();
    }

}
