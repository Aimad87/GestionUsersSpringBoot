package org.cigma.gestionusers;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages={"org.cigma.gestionusers"})
public class GestionUsersApp {

	public static void main(String[] args) {
		SpringApplication.run(GestionUsersApp.class, args);
	}

}
