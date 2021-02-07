package com.dejan;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.dejan.model.User;
import com.dejan.repository.UserRepository;



@SpringBootApplication
public class AirportApiApplication {

	private static final Logger log = LoggerFactory.getLogger(AirportApiApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(AirportApiApplication.class);
	}

	

}
