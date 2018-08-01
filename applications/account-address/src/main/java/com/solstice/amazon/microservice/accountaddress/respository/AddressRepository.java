package com.solstice.amazon.microservice.accountaddress.respository;

import com.solstice.amazon.microservice.accountaddress.model.Address;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AddressRepository extends JpaRepository<Address, Integer>
{
    List<Address> findByAccount(Integer accountId);
}
