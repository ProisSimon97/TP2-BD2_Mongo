package com.example.demo;

import com.example.demo.model.Page;
import com.example.demo.repository.PageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

import java.time.LocalDateTime;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Autowired
	PageRepository repository;

	@Bean
	public CommandLineRunner commandLineRunner(ApplicationContext c) {
		return args -> {

			repository.save(new Page("Prueba", "Es una prueba", "Simon", LocalDateTime.now()));
		};
	}
}

