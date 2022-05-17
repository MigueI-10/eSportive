package com.proyecto.esportive.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.PreRemove;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Range;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "Videojuego")
@Data @AllArgsConstructor @NoArgsConstructor
public class Videojuego implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	//@NotEmpty(message = "No puede estar vacío el nombre")
	private String nombre;

	//@NotEmpty(message = "No puede estar vacío el nombre de la desarrolladora")
	private String desarrolladora;

	//@Range(min=1, max=5)
	private Integer anyoSalida;

	//@NotEmpty(message = "No puede estar vacío el género")
	private String genero;


	private boolean online;

	//@NotEmpty(message = "No puede estar vacío la plataforma")
	private String plataforma;

	//@NotEmpty(message = "La descripcion no puede estar vacia")
	private String descripcion;

	@JsonIgnore
	@OneToMany(mappedBy = "videojuego", cascade={CascadeType.PERSIST})
    private List<Club> clubes;

	@PreRemove
	private void preRemove() {
	   clubes.forEach( child -> child.setVideojuego(null));
	}
	
}
