package com.franceadoni.macchine;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MacchineApplication {

	public static void main(String[] args) {
		SpringApplication.run(MacchineApplication.class, args);
		
		System.out.println("Penny is beautiful");
	}

}
