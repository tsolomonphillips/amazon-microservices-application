package com.solstice.amazon.microservice.accountaddress.service;

import com.solstice.amazon.microservice.accountaddress.model.Account;
import com.solstice.amazon.microservice.accountaddress.respository.AccountRepository;
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
import static org.mockito.Mockito.*;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
public class AccountServiceTest
{
    @Mock
    private AccountRepository accountRepository;

    @InjectMocks
    private AccountService accountService;

    @Before
    public void setUp()
    {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void addAccount()
    {
        Account account = new Account(1, "Lebron", "James",
                "lebron.james@gmail.com");

        when(accountRepository.save(any(Account.class))).thenReturn(account);

        Account newAccount = accountService.addAccount(null);

        assertEquals("Lebron", newAccount.getFirstName());
    }

    @Test
    public void getAllAccounts()
    {
        Account testAccount = new Account(2, "Michael", "Jordan",
                "michael.jordan@gmail.com");
        Account testAccount2 = new Account(3, "Scottie", "Pippen",
                "scottie.pippen@gmail.com");

        List<Account> accountList = new ArrayList<>();

        accountList.add(testAccount);
        accountList.add(testAccount2);

        when(accountRepository.findAll()).thenReturn(accountList);

        verify(accountRepository).findAll();
    }

    @Test
    public void getOneAccount()
    {
        Account testAccount = new Account(2, "Michael", "Jordan",
                "michael.jordan@gmail.com");

        when(accountRepository.getOne(testAccount.getAccountId())).thenReturn(testAccount);

        assertEquals("Michael", testAccount.getFirstName());
    }

    @Test
    public void updateAccount()
    {
        Account account = new Account(1, "James", "Harden",
                "james.harden@gmail.com");

        when(accountRepository.save(any(Account.class))).thenReturn(account);

        Account newAccount = accountService.addAccount(null);

        assertEquals("James", newAccount.getFirstName());


    }
    
    @Test
    public void deleteAccount()
    {
        Account account = new Account(1, "Chris", "Paul",
                "chris.paul@gmail.com");

        verify(accountRepository).deleteById(anyInt());
    }

}
