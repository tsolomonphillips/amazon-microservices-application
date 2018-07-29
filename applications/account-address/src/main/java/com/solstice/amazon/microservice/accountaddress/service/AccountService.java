package com.solstice.amazon.microservice.accountaddress.service;

import com.solstice.amazon.microservice.accountaddress.model.Account;
import com.solstice.amazon.microservice.accountaddress.respository.AccountRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountService
{
    private final AccountRepository accountRepository;

    public AccountService(AccountRepository accountRepository)
    {
        this.accountRepository = accountRepository;
    }

    public Account addAccount(Account account)
    {
        return accountRepository.save(account);
    }

    public List<Account> getAllAccounts()
    {
        return accountRepository.findAll();
    }

    public Account getOneAccount(Integer accountId)
    {
        return accountRepository.getOne(accountId);
    }

    public ResponseEntity updateAccount(Integer accountId, Account account)
    {
        Account accountToUpdate = accountRepository.getOne(accountId);

        accountToUpdate.setFirstName(account.getFirstName());
        accountToUpdate.setLastName(account.getLastName());
        accountToUpdate.setEmailAddress(account.getEmailAddress());

        accountRepository.save(account);
        return new ResponseEntity(HttpStatus.ACCEPTED);
    }

    public ResponseEntity deleteAccount(Integer accountId)
    {
        accountRepository.deleteById(accountId);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }


}
