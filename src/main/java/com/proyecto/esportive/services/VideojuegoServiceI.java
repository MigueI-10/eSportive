package com.proyecto.esportive.services;

import java.util.List;
import java.util.Optional;

import com.proyecto.esportive.entities.Club;
import com.proyecto.esportive.entities.Videojuego;

public interface VideojuegoServiceI {

	public List<Videojuego> obtenerTodosLosVideojuegos();

	public Optional<Videojuego> obtenerVideojuegoPorId(Long id);
	
	public Videojuego obtenerJuegoID(Long id);

	public Optional<Videojuego> obtenerVideojuegoPorNombre(String nombre);
	
	public Videojuego obtenerVideojuegoPorSuNombre(String nombre);

	public Videojuego añadirVideojuego(final Videojuego juego);

	public void eliminarVideojuego(final Long id);

	public Videojuego actualizarVideojuego(final Videojuego juego);

	public List<Videojuego> obtenerVideojuegoPorAño(Integer anyo);

	public List<Videojuego> obtenerVideojuegoPorCreador(String creador);

	public List<Videojuego> obtenerVideojuegoPorGenero(String genero);

	public List<Videojuego> obtenerVideojuegoPorPlataforma(String plataforma);

	public List<Videojuego> obtenerVideojuegoPorOnline(boolean online);
}
