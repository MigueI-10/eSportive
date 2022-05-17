package com.proyecto.esportive.exceptions;

public class JugadorNotFoundException extends RuntimeException{

	private static final long serialVersionUID = 3298952192388848442L;

	public JugadorNotFoundException(Long id) {
		super("No se puede encontrar el jugador con el ID: " + id);
	}

	public JugadorNotFoundException(String nick) {
		super("No se puede encontrar el jugador con el nick: " + nick);
	}
}
