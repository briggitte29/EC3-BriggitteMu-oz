package com.brig.cita.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.brig.cita.DTO.UsuarioClienteDTORequest;
import com.brig.cita.DTO.UsuarioClienteDTOResponse;
import com.brig.cita.seguridad.JwtUtil;
import com.brig.cita.seguridad.UserDetailService;



@RestController
public class UsuarioControlador {
	
	@Autowired
	private JwtUtil util;

	@Autowired
	private UserDetailService service;
	
	@RequestMapping(path = "/crearToken", method = RequestMethod.POST)
	public ResponseEntity<?> crearToken(@RequestBody UsuarioClienteDTORequest dto){
		
		UserDetails detail = service.loadUserByUsername(dto.getUsuario());
		
		return ResponseEntity.ok(new UsuarioClienteDTOResponse(util.generateToken(detail.getUsername())));
	}
}
