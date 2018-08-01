package com.solstice.amazon.microservice.accountaddress.service;

import com.solstice.amazon.microservice.accountaddress.model.Account;
import com.solstice.amazon.microservice.accountaddress.model.Address;
import com.solstice.amazon.microservice.accountaddress.respository.AccountRepository;
import com.solstice.amazon.microservice.accountaddress.respository.AddressRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AddressService
{
    private AddressRepository addressRepository;
    private AccountRepository accountRepository;

    public AddressService(AddressRepository addressRepository, AccountRepository accountRepository)
    {
        this.addressRepository = addressRepository;
        this.accountRepository = accountRepository;
    }

    public ResponseEntity addAddress(Integer accountId, Address address)
    {
        Account account = accountRepository.getOne(accountId);
        address.setAccount(account);

        addressRepository.save(address);
        return new ResponseEntity(HttpStatus.CREATED);
    }

    public List<Address> getAddressList()
    {
        return addressRepository.findAll();
    }

    public List<Address> getAddressByAccount(Integer accountId)
    {
        Account account = accountRepository.getOne(accountId);
        return addressRepository.findByAccount(account.getAccountId());
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

    public Address getAddress(Integer addressId)
    {
        return addressRepository.getOne(addressId);
    }

    public ResponseEntity updateAddress(Integer addressId, Integer accountId, Address address)
    {
        Account account = accountRepository.getOne(accountId);
        Address addressToUpdate = addressRepository.getOne(addressId);

        addressToUpdate.setAptBuilding(address.getAptBuilding());
        addressToUpdate.setCity(address.getCity());
        addressToUpdate.setCountry(address.getCountry());
        addressToUpdate.setStreet(address.getStreet());
        addressToUpdate.setStateProvince(address.getStateProvince());
        addressToUpdate.setZipPostalCode(address.getZipPostalCode());

        addressToUpdate.setAccount(account);

        addressRepository.save(addressToUpdate);
        return new ResponseEntity(HttpStatus.CREATED);
    }

    public ResponseEntity deleteAddress(Integer addressId)
    {
        addressRepository.deleteById(addressId);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }
}
