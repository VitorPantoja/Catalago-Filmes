package com.lead.catalagofilmes;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.UserDetailsServiceAutoConfiguration;



@SpringBootApplication//configuração para desativar o spring
public class CatalagoFilmesApplication {

	public static void main(String[] args) {
		SpringApplication.run(CatalagoFilmesApplication.class, args);



	}

}
