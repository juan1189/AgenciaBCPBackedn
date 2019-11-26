package com.bcp.api.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bcp.api.entities.Agencia;

public interface AgenciaRepository extends JpaRepository<Agencia,String>{

	Optional<Agencia> findByNombre(String nombre);
	
	
}
