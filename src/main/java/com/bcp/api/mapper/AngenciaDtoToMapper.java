package com.bcp.api.mapper;

import java.util.function.Function;

import org.springframework.stereotype.Component;
import org.springframework.util.ObjectUtils;

import com.bcp.api.dto.AgenciaDTO;
import com.bcp.api.entities.Agencia;

@Component
public class AngenciaDtoToMapper implements Function<Agencia,AgenciaDTO>{

	@Override
	public AgenciaDTO apply(Agencia t) {
		AgenciaDTO dto=null;
		
		if (!ObjectUtils.isEmpty(t)) {
			dto =new AgenciaDTO();
			dto.setDistrito(t.getDistrito());
			dto.setProvincia(t.getProvincia());
			dto.setDepartamento(t.getDepartamento());
			dto.setDireccion(t.getDireccion());
			dto.setLatitud(t.getLatitud());
			dto.setLongitud(t.getLongitud());
		}
		
		return dto;
	}

}
