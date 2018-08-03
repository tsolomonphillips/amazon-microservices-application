package com.solstice.amazon.microservice.accountaddress.controller;

import com.solstice.amazon.microservice.accountaddress.model.Address;
import com.solstice.amazon.microservice.accountaddress.service.AddressService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.ws.rs.Path;
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

    @GetMapping("")
    public List<Address> getByAccountId(@PathVariable(name = "account_id") Integer accountId)
    {
        return addressService.getAddressByAccount(accountId);
    }

    @PostMapping("")
    public ResponseEntity addAddress(@PathVariable(name = "account_id") Integer accountId,
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

    @GetMapping("/{addressId}")
    public Address getOneAddress(@PathVariable Integer addressId)
    {
        return addressService.getOneAddress(addressId);
    }

}
