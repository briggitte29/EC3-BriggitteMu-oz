package com.brig.cita.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.brig.cita.DTO.ClienteDTORequest;
import com.brig.cita.DTO.ClienteDTOResponse;
import com.brig.cita.servicio.ClienteServicio;




@RestController
@RequestMapping("/cliente/v1")
public class ClienteController {
	
	@Autowired
	private ClienteServicio servicio;

	
	@RequestMapping(path = "/listar", method = RequestMethod.GET)
	public ResponseEntity<List<ClienteDTOResponse>> listarClientes(){
		
		return new ResponseEntity<List<ClienteDTOResponse>>(servicio.listarClientes(), HttpStatus.CREATED);  
	}
	
	@RequestMapping(path = "/guardar", method = RequestMethod.POST)
	public ResponseEntity<Void> guardar(@RequestBody ClienteDTORequest cliente){
		
		
		servicio.guardarCliente(cliente);
		return  new ResponseEntity<Void>(HttpStatus.CREATED);
		
	}
	
	@RequestMapping(path = "/listar/{id}" , method = RequestMethod.GET)
	public ResponseEntity<ClienteDTOResponse> listarPorId(@PathVariable Integer id) {
		
		ClienteDTOResponse c = servicio.obtenerClienteId(id);
		if(c != null)
			return new ResponseEntity<ClienteDTOResponse>(c, HttpStatus.OK);
		
		return new ResponseEntity<ClienteDTOResponse>(HttpStatus.NOT_FOUND);
		
	}
	
	@RequestMapping(path = "/editar", method = RequestMethod.PUT)
	public ResponseEntity<Void> editar(@RequestBody ClienteDTORequest cliente){
		
		ClienteDTOResponse c = servicio.obtenerClienteId(cliente.getIdClienteDTO());

		if(c != null) {
			servicio.editarCliente(cliente);
			return new ResponseEntity<Void>(HttpStatus.OK);
		}
		
		return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		
	}
	
	@RequestMapping(path = "/eliminar/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> eliminar(@PathVariable Integer id){
		
		ClienteDTOResponse c = servicio.obtenerClienteId(id);
		if(c != null) {
			servicio.eliminarCliente(id);
			return new ResponseEntity<Void>(HttpStatus.OK);
		}
		
		return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);

		
	}

}
