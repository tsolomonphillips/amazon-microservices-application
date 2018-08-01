package com.solstice.amazon.microservice.accountaddress.controller;

import com.solstice.amazon.microservice.accountaddress.model.Address;
import com.solstice.amazon.microservice.accountaddress.service.AddressService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/accounts/{account_id}/address")
public class AddressController
{
    private AddressService addressService;

    public AddressController(AddressService addressService)
    {
        this.addressService = addressService;
    }

    // TODO: 8/1/18 Need to fix this method (I am getting a (405 error code with a message of Method not allowed and request method not supported
    // todo and org.springframework.web.HttpRequestMethodNotSupportedException: request method GET not supported

    @GetMapping("account_id")
    public List<Address> getByAccountId(@PathVariable Integer accountId)
    {
        return addressService.getAddressByAccount(accountId);
    }

//    @GetMapping("")
//    public Address getAddressById(@PathVariable Integer addressId)
//    {
//        return addressService.getAddress(addressId);
//    }

    @PostMapping("")
    public ResponseEntity addAddress(@PathVariable Integer accountId,
                                     @RequestBody Address address)
    {
        addressService.addAddress(accountId, address);
        return new ResponseEntity(HttpStatus.CREATED);
    }

    @DeleteMapping("")
    public ResponseEntity deleteAddress(@PathVariable Integer addressId)
    {
        addressService.deleteAddress(addressId);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }
}
