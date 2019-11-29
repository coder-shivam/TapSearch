package com.shivam.tapSearch.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.shivam.tapSearch.*"})
public class TapSearchApplication extends SpringBootServletInitializer {

	public static void main(String[] args) {
		SpringApplication.run(TapSearchApplication.class, args);
	}
}
