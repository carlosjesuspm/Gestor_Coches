package com.cjpm.gestorcoches;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.cjpm.gestorcoches")
public class GestorCochesApplication {

	public static void main(String[] args) {
		SpringApplication.run(GestorCochesApplication.class, args);
	}

}
