package com.Synoc.store;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication
public class SynocApplication {

	public static void main(String[] args) {
		SpringApplication.run(SynocApplication.class, args);
	}

}
