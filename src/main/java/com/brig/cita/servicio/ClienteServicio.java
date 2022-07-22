package com.brig.cita.servicio;

import java.util.List;

import com.brig.cita.DTO.ClienteDTORequest;
import com.brig.cita.DTO.ClienteDTOResponse;

public interface ClienteServicio {
	
	public void guardarCliente(ClienteDTORequest cliente);
	public void editarCliente(ClienteDTORequest cliente);
	
	public void eliminarCliente(Integer id);
	
	public List<ClienteDTOResponse> listarClientes();
	public ClienteDTOResponse obtenerClienteId(Integer id);

}
