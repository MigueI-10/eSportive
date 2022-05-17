package com.proyecto.esportive.exceptions;

public class VideojuegoNotFoundException extends RuntimeException{

	private static final long serialVersionUID = 3298952192388848442L;

	public VideojuegoNotFoundException(Long id) {
		super("No se puede encontrar el videojuego con el ID: " + id);
	}

	public VideojuegoNotFoundException(String nombre) {
		super("No se puede encontrar el videojuego con el nombre: " + nombre);
	}
}
