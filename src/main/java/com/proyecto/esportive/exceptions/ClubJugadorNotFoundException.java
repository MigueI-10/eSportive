package com.proyecto.esportive.exceptions;

public class ClubJugadorNotFoundException extends RuntimeException{

	private static final long serialVersionUID = 3298952192388848442L;

	public ClubJugadorNotFoundException(Long id) {
		super("No se puede encontrar el clubjugador con el ID: " + id);
	}

	public ClubJugadorNotFoundException(String nombre) {
		super("No se puede encontrar el clubjugador con el nombre: " + nombre);
	}


}
