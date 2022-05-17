package com.proyecto.esportive.exceptions;

public class ClubNotFoundException extends RuntimeException{

	private static final long serialVersionUID = 3298952192388848442L;

	public ClubNotFoundException(Long id) {
		super("No se puede encontrar el club con el ID: " + id);
	}

	public ClubNotFoundException(String cad) {
		super("No se puede encontrar el club con el nombre: " + cad);
	}
	
}
