package com.solstice.amazon.microservice.accountaddress.service;

import com.solstice.amazon.microservice.accountaddress.model.Address;
import com.solstice.amazon.microservice.accountaddress.respository.AddressRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AddressService
{
    private AddressRepository addressRepository;

    public AddressService(AddressRepository addressRepository)
    {
        this.addressRepository = addressRepository;
    }

    public ResponseEntity addAddress(Address address)
    {
        addressRepository.save(address);
        return new ResponseEntity(HttpStatus.CREATED);
    }

    public List<Address> getAddressList()
    {
        return addressRepository.findAll();
    }

    public Address getOneAddress(Integer addressId)
    {
        try
        {
            Address address = addressRepository.getOne(addressId);

            if (getAddressList().contains(address))
            {
                return address;
            }
            else
            {
                throw new IllegalArgumentException();
            }
        }
        catch (Exception e)
        {
            e.getMessage();
            e.printStackTrace();
        }

        return null;
    }

    public ResponseEntity updateAddress(Integer addressId, Address address)
    {
        Address addressToUpdate = addressRepository.getOne(addressId);

        addressToUpdate.setAptBuilding(address.getAptBuilding());
        addressToUpdate.setCity(address.getCity());
        addressToUpdate.setCountry(address.getCountry());
        addressToUpdate.setStreet(address.getStreet());
        addressToUpdate.setStateProvince(address.getStateProvince());
        addressToUpdate.setZipPostalCode(address.getZipPostalCode());

        addressRepository.save(addressToUpdate);
        return new ResponseEntity(HttpStatus.CREATED);
    }

    public ResponseEntity deleteAddress(Integer addressId)
    {
        addressRepository.deleteById(addressId);
        return new ResponseEntity(HttpStatus.ACCEPTED);
    }
}
