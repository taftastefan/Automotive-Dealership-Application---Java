package com.example.ProiectAWJ;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ProiectAwjApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProiectAwjApplication.class, args);
		System.out.println("Aplicatia ruleaza la: http://localhost:8080");
		String url = "jdbc:postgresql://localhost:5432/DealershipAuto";
		String username = "postgres";
		String password = "parola123";
	}
}
