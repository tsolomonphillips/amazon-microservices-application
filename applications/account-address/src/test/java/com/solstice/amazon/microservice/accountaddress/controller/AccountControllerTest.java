package com.solstice.amazon.microservice.accountaddress.controller;

import com.solstice.amazon.microservice.accountaddress.model.Account;
import com.solstice.amazon.microservice.accountaddress.service.AccountService;
import com.sun.org.apache.xerces.internal.parsers.SecurityConfiguration;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(AccountController.class)
@ContextConfiguration(classes = {SecurityConfiguration.class})
public class AccountControllerTest
{
    @Autowired
    private MockMvc mockMvc;

    @Mock
    private AccountService accountService;

    @InjectMocks
    private AccountController accountController;

    @Before
    public void setUp()
    {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void AddAccount() throws Exception
    {
        Account testAccount = new Account(1, "Thomas", "Merton",
                "thomas.merton@gmail.com");

        when(accountService.addAccount(testAccount)).thenReturn(testAccount);

        mockMvc
                .perform(post("/accounts")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andReturn();
    }

    @Test
    public void getAllAccounts() throws Exception
    {

        List<Account> accountList = new ArrayList<>();

        Account testAccount = new Account(1, "William", "Merton",
                "william.merton@gmail.com");
        Account testAccount2 = new Account(2, "Michael", "Jordan",
                "michael.jordan@gmail.com");
        Account testAccount3 = new Account(3, "Kobe", "Bryant",
                "kobe.bryant@gmail.com");

        accountList.add(testAccount);
        accountList.add(testAccount2);
        accountList.add(testAccount3);


        when(accountService.getAllAccounts()).thenReturn(accountList);

        mockMvc
                .perform(get("/accounts")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andReturn();
    }

    @Test
    public void getOneAccount() throws Exception
    {
        Account testAccount = new Account(1, "Thomas", "Merton",
                "thomas.merton@gmail.com");

        when(accountService.getOneAccount(testAccount.getAccountId())).thenReturn(testAccount);

        mockMvc.perform(get("/accounts/1")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andReturn();
    }

    @Test
    public void updateAccount() throws Exception
    {
        Account testAccount = new Account(1, "Thomas", "Merton",
                "thomas.merton@gmail.com");

        Account accountToUpdate = new Account(1);

        when(accountService.updateAccount(accountToUpdate.getAccountId(), testAccount))
                .thenReturn(new ResponseEntity(HttpStatus.ACCEPTED));

        mockMvc
                .perform(put("/accounts/{accountid}")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk()).andReturn();

    }

    @Test
    public void deleteAccount() throws Exception
    {
        Account testAccount = new Account(1, "Thomas", "Merton",
                "thomas.merton@gmail.com");

        when(accountService.deleteAccount(testAccount.getAccountId()))
                .thenReturn(new ResponseEntity(HttpStatus.ACCEPTED));

        mockMvc
                .perform(put("/accounts/{accountid}")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk()).andReturn();
    }

}
