package com.brig.cita.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.brig.cita.models.UsuarioCliente;


@Repository
public interface UsuarioClienteRepository extends JpaRepository<UsuarioCliente, Integer>{

	
	UsuarioCliente findByUsuario(String usuario);
}
