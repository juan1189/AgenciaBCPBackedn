package com.bcp.api.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bcp.api.dto.AgenciaDTO;
import com.bcp.api.entities.Agencia;
import com.bcp.api.jwt.MyUserDetailsService;
import com.bcp.api.jwt.model.AuthenticationRequest;
import com.bcp.api.jwt.model.AuthenticationResponse;
import com.bcp.api.jwt.util.JwtUtil;
import com.bcp.api.mapper.AngenciaDtoToMapper;
import com.bcp.api.service.AgenciaService;
import com.bcp.api.util.RestUtil;
import com.bcp.api.util.ResultEntity;

@RestController
@RequestMapping("api/v1")
public class AgenciaController {
	
	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private JwtUtil jwtTokenUtil;

	@Autowired
	private MyUserDetailsService userDetailsService;

	
	@Autowired
	private AgenciaService agenciaService;
	
	@Autowired
	private AngenciaDtoToMapper agenciaDTOMapper;
	
	@GetMapping("agencias")
    public ResultEntity<AgenciaDTO> buscarAgenciaPorNombre(@RequestParam String nombre) {
			
		  Optional<Agencia> agenciaOpt = agenciaService.buscarPorNombre(nombre);
		  if(agenciaOpt.isPresent()) {
			  return  RestUtil.getRestEntityOK(agenciaDTOMapper.apply(agenciaOpt.get()));
		  }else {
			  return RestUtil.getRestEntityNoContent();
		  }	
    }

	@GetMapping("agencias/listar")
    public ResponseEntity<?> listarAgencias(Pageable pageable) {		
		return ResponseEntity.ok().body(agenciaService.listarAgencias(pageable));
    }
	
	@PostMapping("authenticate")
	public ResultEntity<AuthenticationResponse> crearToken(@RequestBody AuthenticationRequest authenticationRequest) throws Exception {

		try {
			authenticationManager.authenticate(
					new UsernamePasswordAuthenticationToken(authenticationRequest.getUsername(), authenticationRequest.getPassword())
			);
		}
		catch (BadCredentialsException e) {
			throw new Exception("Usuario o clave incorrecto", e);
		}


		final UserDetails userDetails = userDetailsService
				.loadUserByUsername(authenticationRequest.getUsername());

		final String jwt = jwtTokenUtil.generateToken(userDetails);

		return RestUtil.getRestEntityOK(new AuthenticationResponse(jwt));
	}
	
}
