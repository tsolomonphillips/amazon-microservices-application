package com.solstice.amazon.microservice.accountaddress;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication
public class AccountAddressApplication
{

	public static void main(String[] args)
	{
		SpringApplication.run(AccountAddressApplication.class, args);
	}
}
