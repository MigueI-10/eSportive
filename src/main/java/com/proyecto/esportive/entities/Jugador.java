package com.proyecto.esportive.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.PreRemove;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "Jugador")
@Data@NoArgsConstructor@AllArgsConstructor
public class Jugador implements Serializable{

	private static final long serialVersionUID = 1L;

	/**
	 * Id del jugador
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;


	/**
	 * Nombre del jugador
	 */
	//@NotEmpty(message = "El nombre no puede estar vacio")
	//@Size(min = 4, max = 15, message = "el tamaño tiene que estar entre 4 y 15")
	private String nombre;

	/**
	 * Apellido del jugador
	 */
	//@NotEmpty(message = "El apellido no puede estar vacio")
	//@Size(min = 4, max = 25, message = "el tamaño tiene que estar entre 4 y 25")
	private String apellido;

	/**
	 * Fecha de NAcimiento del jugador
	 */
	@Temporal(TemporalType.DATE)
	@Column(nullable = false)
	private Date fechaNac;

	/**
	 * nacionalidad del jugador
	 */
	//@NotEmpty(message = "La nacionalidad no puede estar vacio")
	//@Size(min = 4, max = 20, message = "el tamaño tiene que estar entre 4 y 20")
	private String nacionalidad;


	//@NotEmpty(message = "El nickname no puede estar vacio")
	//@Size(min = 4, max = 20, message = "el tamaño tiene que estar entre 4 y 20")
	private String nickname;

	//@NotEmpty(message = "El salario no puede estar vacio")
	//@Size(min = 3, max = 9, message = "el tamaño tiene que estar entre 4 y 9")
	private double salario;

	//@NotEmpty(message = "Las victorias no puede estar vacias")
	//@Size(min = 1, max = 9, message = "el tamaño tiene que estar entre 1 y 9")
	private Integer maxVictorias;

	/**
	 * lista de equipos futbolistas de la clase futbolista
	 */
	@JsonIgnore
	@OneToMany(mappedBy = "jugador", fetch = FetchType.LAZY, cascade={CascadeType.PERSIST})
	private List<ClubJugador> clubjugadores;

	@PreRemove
	private void preRemove() {
	   clubjugadores.forEach( child -> child.setJugador(null));
	}

}
