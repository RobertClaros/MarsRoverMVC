package com.marsRover;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.marsRover")
public class MarsRoverApplication {

	public static void main(String[] args) {
		SpringApplication.run(MarsRoverApplication.class, args);
	}

}
