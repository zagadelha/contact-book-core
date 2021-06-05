package com.contactbook;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class ContactBookCoreApplication {

	public static void main(String[] args) {
		SpringApplication.run(ContactBookCoreApplication.class, args);
	}

}
