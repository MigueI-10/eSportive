package com.proyecto.esportive.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.PreRemove;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "Club")
@Data @AllArgsConstructor @NoArgsConstructor
public class Club implements Serializable{

	private static final long serialVersionUID = 1L;

	/***
	 * Id del equipo
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	/***
	 * Nombre del equipo
	 */
	//@NotEmpty(message = "El nombre no puede estar vacio")
	//@Size(min = 4, max = 25, message = "el tamaño tiene que estar entre 4 y 25")
	@Column(nullable = false)
	private String nombre;

	/***
	 * Procedencia del equipo
	 */
	//@NotEmpty(message = "La procedencia no puede estar vacia")
	//@Size(min = 4, max = 25, message = "el tamaño tiene que estar entre 4 y 25")
	@Column(nullable = false)
	private String procedencia;

	/***
	 * Propietario del equipo
	 */
	//@NotEmpty(message = "El propietario no puede estar vacio")
	//@Size(min = 4, max = 25, message = "el tamaño tiene que estar entre 4 y 25")
	@Column(nullable = false)
	private String propietario;

	/***
	 * Propietario del equipo
	 */
	//@NotEmpty(message = "El año de creacion no puede estar vacio")
	//@Size(min = 1, max = 4, message = "el tamaño tiene que estar entre 1 y 4")
	@Column(nullable = false)
	private Integer anyoCreacion;

	/***
	 * Descripcion del equipo
	 */
	//@NotEmpty(message = "La descripcion no puede estar vacio")
	//@Size(min = 5, max = 300, message = "el tamaño tiene que estar entre 5 y 300")
	private String descripcion;

	//@NotEmpty(message = "El año de creacion no puede estar vacio")
	//@Size(min = 1, max = 5, message = "el tamaño tiene que estar entre 1 y 5")
	@Column(nullable = false)
	private Integer numeroTrofeos;

	//@NotEmpty(message = "El año de creacion no puede estar vacio")
	//@Size(min = 1, max = 9, message = "el tamaño tiene que estar entre 1 y 9")
	@Column(nullable = false)
	private Integer puntosActuales;

	@ManyToOne
    @JoinColumn(name="videojuego_id")
	
    private Videojuego videojuego;

	/***
	 * Lista de equipo futbolista
	 */
	@JsonIgnore
	@OneToMany(mappedBy="club", cascade={CascadeType.PERSIST})
	private List<ClubJugador> clubjugadores;

	@PreRemove
	private void preRemove() {
	   clubjugadores.forEach( child -> child.setClub(null));
	}

}
