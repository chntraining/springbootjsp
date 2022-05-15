package com.cts.ems027;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;


@SpringBootApplication
public class Ems027Application extends SpringBootServletInitializer {

	
	public Ems027Application() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(Ems027Application.class);
	}

	public static void main(String[] args) {
		SpringApplication.run(Ems027Application.class, args);
	}

}
