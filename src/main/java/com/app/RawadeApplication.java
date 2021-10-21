package com.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
@SpringBootApplication( scanBasePackages = { "com.app" })
public class RawadeApplication {

	public static void main(String[] args) {
		SpringApplication.run(RawadeApplication.class, args);
	}

}
