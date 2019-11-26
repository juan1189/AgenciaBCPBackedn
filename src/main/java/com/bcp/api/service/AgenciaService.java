package com.bcp.api.service;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.bcp.api.entities.Agencia;
import com.bcp.api.mapper.AngenciaToMapper;
import com.bcp.api.model.json.AgenciaJSON;
import com.bcp.api.repository.AgenciaRepository;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class AgenciaService {

	@Autowired
	private AgenciaRepository agenciaRespository;
	
	@Autowired
	private AngenciaToMapper agenciaToMapper;
	
	@Transactional
	public Agencia cargarJsonEnBD() throws IOException{
		ObjectMapper objectMapper = new ObjectMapper();
		Agencia ultimaAgencia = null;
		List<AgenciaJSON> listAgenciasJSON = objectMapper.readValue(new File("agenciasBCP.json"), objectMapper.getTypeFactory().constructCollectionType(List.class, AgenciaJSON.class));
		
		if(listAgenciasJSON != null && !listAgenciasJSON.isEmpty())
			for (AgenciaJSON agenciaJSON : listAgenciasJSON) {
				ultimaAgencia = agenciaRespository.save(agenciaToMapper.apply(agenciaJSON));
			}
		
		return ultimaAgencia;
	}
	
	public Optional<Agencia> buscarPorNombre(String nombre) {		
		Optional<Agencia> agencia = agenciaRespository.findByNombre(nombre);		
		return agencia;
	}
	
	public Page<Agencia> listarAgencias(Pageable pageable){	
		return agenciaRespository.findAll(pageable);
	}
}
