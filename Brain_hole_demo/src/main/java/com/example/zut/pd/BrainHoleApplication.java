package com.example.zut.pd;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan("com.example.zut.pd")
@SpringBootApplication
public class BrainHoleApplication {

	public static void main(String[] args) {
		SpringApplication.run(BrainHoleApplication.class, args);
	}

}
