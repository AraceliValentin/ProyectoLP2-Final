package com.cibertec;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
@SpringBootApplication
//Le indica a Spring dónde buscar las entidades JPA
@EntityScan(basePackages = { "com.cibertec.modelos" })
//Habilita el repositorio y dónde encontrarlo
@EnableJpaRepositories(basePackages = { "com.cibertec.repositorio" })
//Le indica a Spring dónde buscar los controladores
@ComponentScan(basePackages = { "com.cibertec.controladores" })
public class Lp2ProyectoFinalApplication {

	public static void main(String[] args) {
		SpringApplication.run(Lp2ProyectoFinalApplication.class, args);
	}

}
