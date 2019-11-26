package com.bcp.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.bcp.api.service.AgenciaService;

@SpringBootApplication
public class AgenciaApiApplication implements CommandLineRunner{

	@Autowired
	private AgenciaService agenciaService;
	
	public static void main(String[] args) {
		SpringApplication.run(AgenciaApiApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		agenciaService.cargarJsonEnBD();		
	}

}
