package com.brig.cita.models;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name= "UsuarioCliente")
public class UsuarioCliente {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idUsuario;
	private String usuario;
	private String password;
	private String rol;
	private Integer idCliente;
	
	@OneToOne
	private Cliente cliente;
	
	
	@ManyToMany
	@JoinTable(name="usucliente_hospital",
			joinColumns = @JoinColumn(name= "id_Usuario", nullable = false, unique = true, foreignKey = @ForeignKey(foreignKeyDefinition = "foreing key(id_Usuario) references usucliente (id_Usuario)")),
			inverseJoinColumns = @JoinColumn(name= "id_Hospital", nullable = false, unique = true, foreignKey = @ForeignKey(foreignKeyDefinition = "foreing key(id_Hospital) references hospital(id_Hospital)")))
	private List<Hospital> hospital= new ArrayList<>();

}
