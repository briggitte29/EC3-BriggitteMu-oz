package com.brig.cita.servicio;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.brig.cita.DTO.ClienteDTORequest;
import com.brig.cita.DTO.ClienteDTOResponse;
import com.brig.cita.models.Cliente;
import com.brig.cita.repository.ClienteRepository;

@Service
public class ClienteServicioImpl implements ClienteServicio {

	@Autowired
	public ClienteRepository repositorio;

	@Override
	public void guardarCliente(ClienteDTORequest cliente) {
		 
		Cliente c= new Cliente();
		c.setNombre(cliente.getNombreDTO());
		c.setIdCliente(cliente.getIdClienteDTO());
		c.setCelular(cliente.getCelularDTO());
		
		repositorio.save(c);
	}

	@Override
	public void editarCliente(ClienteDTORequest cliente) {
		
		Cliente c= new Cliente();
		c.setNombre(cliente.getNombreDTO());
		c.setIdCliente(cliente.getIdClienteDTO());
		c.setCelular(cliente.getCelularDTO());
		
		repositorio.saveAndFlush(c);
		
	}

	@Override
	public void eliminarCliente(Integer id) {
		
		repositorio.deleteById(id);
		
	}

	@Override
	public List<ClienteDTOResponse> listarClientes() {
		
		List<ClienteDTOResponse> lista= new ArrayList<ClienteDTOResponse>();
		ClienteDTOResponse c= null;
		
		for(Cliente cliente: repositorio.findAll()) {
			c= new ClienteDTOResponse();
			
			c.setNombreDTO(cliente.getNombre());	
			c.setIdClienteDTO(cliente.getIdCliente());
			c.setCelularDTO(cliente.getCelular());
			
			lista.add(c);
			
		}
		return lista;
	}

	@Override
	public ClienteDTOResponse obtenerClienteId(Integer id) {
		
		Cliente cliente= repositorio.findById(id).orElse(null);
		ClienteDTOResponse c= new ClienteDTOResponse();
		
		c.setNombreDTO(cliente.getNombre());
		c.setIdClienteDTO(cliente.getIdCliente());
		c.setCelularDTO(cliente.getCelular());
		
		return c;
	}
	
	
}
