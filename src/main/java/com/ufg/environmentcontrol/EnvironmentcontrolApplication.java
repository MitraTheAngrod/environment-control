package com.ufg.environmentcontrol;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

// Excludes the auto Spring Boot Security autoconfiguration from the application
@SpringBootApplication(exclude = {SecurityAutoConfiguration.class})
public class EnvironmentcontrolApplication {

	public static void main(String[] args) {
		SpringApplication.run(EnvironmentcontrolApplication.class, args);
	}

	// Specifies that it's part of the application
	// Creates a password encoder(BCrypt in this case)
	@Bean
	public PasswordEncoder getPasswordEncoder() {
		return new BCryptPasswordEncoder();
	}
}
