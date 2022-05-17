package com.proyecto.esportive.services;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import com.proyecto.esportive.entities.Club;
import com.proyecto.esportive.entities.ClubJugador;
import com.proyecto.esportive.entities.Jugador;

public interface ClubJugadorServiceI {

	public List<ClubJugador> obtenerTodosClubJugad();

	public List<ClubJugador> obtenerHistoriaJugador(final long id);

	public List<ClubJugador> obtenerHistoriaClub(final long idClub);
	
	public Optional<ClubJugador> obtenerJugadorPorId(Long id);
	
	public ClubJugador obtenerClubJugadorID(Long id);

	public void eliminarClubJugPorId(final long id);

	public ClubJugador aniadirClubJug(final ClubJugador clubj);

	public ClubJugador actualizarClubJug(final ClubJugador clubj);
	
	public List<ClubJugador> obtenerPorTrofeos(Integer trofeos);

	public List<ClubJugador> obtenerPorFechas(String fechaInicio, String fechaFin);
	
}
