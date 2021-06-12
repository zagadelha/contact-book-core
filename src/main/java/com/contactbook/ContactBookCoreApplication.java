package com.contactbook;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
//@FeignClient(name = "cb-core", path = "core")
@SpringBootApplication
public class ContactBookCoreApplication {

	public static void main(String[] args) {
		SpringApplication.run(ContactBookCoreApplication.class, args);
	}

}
