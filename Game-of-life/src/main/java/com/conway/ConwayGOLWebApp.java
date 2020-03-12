package com.conway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.conway")
public class ConwayGOLWebApp {
	 public static void main(String[] args) {
	        SpringApplication.run(ConwayGOLWebApp.class, args);
	    }
}
