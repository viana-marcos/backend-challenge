package com.invillia.acme;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableAutoConfiguration
@ComponentScan(basePackages={"com.invillia"})
@EnableJpaRepositories("com.invillia.repository")
@EntityScan("com.invillia.model")
public class InvilliaApplication {

	public static void main(String[] args) {
		SpringApplication.run(InvilliaApplication.class, args);
	}
}
