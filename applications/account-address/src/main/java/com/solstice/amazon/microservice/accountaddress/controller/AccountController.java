package com.solstice.amazon.microservice.accountaddress.controller;

import com.solstice.amazon.microservice.accountaddress.model.Account;
import com.solstice.amazon.microservice.accountaddress.service.AccountService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/accounts")
public class AccountController
{
    private AccountService accountService;

    public AccountController(AccountService accountService)
    {
        this.accountService = accountService;
    }

    @GetMapping("")
    public List<Account> getAllAccounts()
    {
        return accountService.getAllAccounts();
    }

    @GetMapping("/{accountId}")
    public Account getOneAccount(@PathVariable Integer accountId)
    {
        return accountService.getOneAccount(accountId);
    }

    @PostMapping("")
    public Account addAccount(@RequestBody Account account)
    {
        return accountService.addAccount(account);
    }
}
