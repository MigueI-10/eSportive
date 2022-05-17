package com.proyecto.esportive.services;

import java.util.List;
import java.util.Optional;

import com.proyecto.esportive.entities.Club;

public interface ClubServiceI {

	public List<Club> obtenerTodosLosClubes();

	public Optional<Club> obtenerClubPorId(Long id);
	
	public Club obtenerClubID(Long id);
	
	public Club obtenerNombre(String nombre);

	public Optional<Club> obtenerClubPorNombre(String nombre);

	public Club añadirClub(final Club club);

	public void eliminarClub(final Long id);

	public Club actualizarClub(final Club club);

	public List<Club> obtenerPorPropietario(String owner);

	public List<Club> obtenerPorPais(String pais);

	public List<Club> obtenerPorAño(Integer anyo);

	public List<Club> obtenerPorPuntosMas(Integer puntos);
	
	public List<Club> obtenerPorPuntosMenos(Integer puntos);

	public List<Club> obtenerPorTrofeosMas(Integer trofeos);
	
	public List<Club> obtenerPorTrofeosMenos(Integer trofeos);

}
