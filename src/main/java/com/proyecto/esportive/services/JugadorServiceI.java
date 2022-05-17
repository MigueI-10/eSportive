package com.proyecto.esportive.services;

import java.util.List;

import java.util.Optional;

import com.proyecto.esportive.entities.ClubJugador;
import com.proyecto.esportive.entities.Jugador;

public interface JugadorServiceI {

	public List<Jugador> obtenerTodosLosJugadores();

	public Optional<Jugador> obtenerJugadorPorId(Long id);
	
	public Jugador obtenerJugadorID(Long id);
	
	public Optional<Jugador> obtenerJugadorNick(String nick);
	
	public Jugador obtenerJugadorConNick(String nick);

	public Jugador obtenerJugadorPorNombre(String nombre);

	public Jugador añadirJugador(final Jugador jugador);

	public void eliminarJugador(final Long id);

	public Jugador actualizarJugador(final Jugador jugador);

	public List<Jugador> obtenerJugadorPorApellido(String apellido);

	public List<Jugador> obtenerJugadorPorNickname(String nickname);

	public List<Jugador> obtenerJugadorPorPais(String pais);

	public List<Jugador> obtenerJugadorPorVictoriasMas(Integer victorias);
	
	public List<Jugador> obtenerJugadorPorVictoriasMenos(Integer victorias);

	public List<Jugador> obtenerJugadorPorSalarioMas(Double salario);
	
	public List<Jugador> obtenerJugadorPorSalarioMenos(Double salario);
	
	public List<Jugador> obtenerPorFechas(String fechaInicio, String fechaFin);

}
