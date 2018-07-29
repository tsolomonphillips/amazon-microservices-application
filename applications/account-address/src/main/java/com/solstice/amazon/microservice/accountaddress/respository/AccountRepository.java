package com.solstice.amazon.microservice.accountaddress.respository;

import com.solstice.amazon.microservice.accountaddress.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepository extends JpaRepository<Account, Integer>
{

}
