package com.bcp.api.mapper;

import java.util.function.Function;

import org.springframework.stereotype.Component;
import org.springframework.util.ObjectUtils;

import com.bcp.api.entities.Agencia;
import com.bcp.api.model.json.AgenciaJSON;

@Component
public class AngenciaToMapper implements Function<AgenciaJSON,Agencia>{

	@Override
	public Agencia apply(AgenciaJSON t) {
		
		Agencia agencia=null;
        
		if (!ObjectUtils.isEmpty(t)) {
			agencia =new Agencia();
			agencia.setDepartamento(t.getDepartamento());
			agencia.setDireccion(t.getDireccion());
			agencia.setDistrito(t.getDistrito());
			agencia.setLatitud(t.getLat());
			agencia.setLongitud(t.getLon());
			agencia.setNombre(t.getAgencia());
			agencia.setProvincia(t.getProvincia());
        }
	        
		return agencia;
	}

}
