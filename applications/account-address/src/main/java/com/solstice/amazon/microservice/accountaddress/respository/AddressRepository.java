package com.solstice.amazon.microservice.accountaddress.respository;

import com.solstice.amazon.microservice.accountaddress.model.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<Address, Integer>
{

}
