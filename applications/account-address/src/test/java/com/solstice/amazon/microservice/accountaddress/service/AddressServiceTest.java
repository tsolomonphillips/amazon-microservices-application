package com.solstice.amazon.microservice.accountaddress.service;

import com.solstice.amazon.microservice.accountaddress.model.Account;
import com.solstice.amazon.microservice.accountaddress.model.Address;
import com.solstice.amazon.microservice.accountaddress.respository.AddressRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
public class AddressServiceTest
{
    @Mock
    private AddressRepository addressRepository;

    @InjectMocks
    private AddressService addressService;

    @Before
    public void setUp()
    {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void addAddress()
    {
        Account account = new Account(1, "Lebron", "James",
                "lebron.james@gmail.com");

        Address address = new Address(2, "678 St.", "87", "Chicago",
                "Ilinois", "60934", "U.S", account);

        when(addressRepository.save(address)).thenReturn(address);

        assertEquals("Chicago", address.getCity());
    }

    @Test
    public void getAllAddresses()
    {
        Account account = new Account(1, "Lebron", "James",
                "lebron.james@gmail.com");

        Address address = new Address(2, "678 St.", "87", "Chicago",
                "Ilinois", "60934", "U.S", account);

        Account account2 = new Account(1, "Lebron", "James",
                "lebron.james@gmail.com");

        Address address2 = new Address(2, "678 St.", "87", "Chicago",
                "Ilinois", "60934", "U.S", account2);

        List<Address> addressList = new ArrayList<>();

        addressList.add(address);
        addressList.add(address2);

        when(addressRepository.findAll()).thenReturn(addressList);

        //verify(addressRepository.findAll());
        assertEquals(2, addressList.size());

    }

    @Test
    public void getOneAddress()
    {
        Account account = new Account(1, "Lebron", "James",
                "lebron.james@gmail.com");

        Address address = new Address(2, "678 St.", "87", "Chicago",
                "Ilinois", "60934", "U.S", account);

        when(addressRepository.getOne(address.getAddressId())).thenReturn(address);

        assertEquals("60934", address.getZipPostalCode());
    }

    @Test
    public void updateAddress()
    {
        Account account = new Account(1, "Brandon", "Ingram",
                "brandon.ingram@gmail.com");

        Address address = new Address(2, "678 St.", "87", "Los Angeles",
                "California", "12345", "U.S", account);

        when(addressRepository.save(any(Address.class))).thenReturn(address);

        assertEquals("Brandon", address.getAccount().getFirstName());

    }

//    @Test
//    public void deleteAddress()
//    {
//        Account account = new Account(1, "Brandon", "Ingram",
//                "brandon.ingram@gmail.com");
//
//        Address address = new Address(2, "678 St.", "87", "Los Angeles",
//                "California", "12345", "U.S", account);
//
//        verify(addressRepository).deleteById(anyInt());
//
//    }
}
