package com.bridgelabz.addressbookapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import lombok.extern.slf4j.Slf4j;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableSwagger2
@SpringBootApplication
@Slf4j
public class AddressBookAppApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(AddressBookAppApplication.class, args);
		log.info("AddressBook App Started {} Environment", context.getEnvironment().getProperty("environment"));
	}
}
