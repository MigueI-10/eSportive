package com.proyecto.esportive.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "ClubJugador")
@Data @AllArgsConstructor @NoArgsConstructor
public class ClubJugador implements Serializable {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Id del equipo futbolista
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	/**
	 * Equipo del equipo futbolista
	 */
	@ManyToOne
    @JoinColumn(name = "club_id")
    Club club;

	/**
	 * Futbolista del equipo futbolista
	 */
	
    @ManyToOne
    @JoinColumn(name = "jugador_id")
    Jugador jugador;

   /**
	 * Temporada del equipo futbolista
	 */
    @Temporal(TemporalType.DATE)
    @Column(nullable = false)
    private Date temporada;

    //@NotEmpty(message = "Los trofeos no puede estar vacios")
	//@Size(min = 1, max = 4, message = "el tamaño tiene que estar entre 1 y 4")
	@Column(nullable = false)
	private Integer trofeosIndividuales;

}
