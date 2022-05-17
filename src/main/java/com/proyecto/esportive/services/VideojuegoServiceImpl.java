package com.proyecto.esportive.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proyecto.esportive.entities.Videojuego;
import com.proyecto.esportive.repository.VideojuegoRepository;

@Service
public class VideojuegoServiceImpl implements VideojuegoServiceI{

	@Autowired
	private VideojuegoRepository repos;

	@Override
	public List<Videojuego> obtenerTodosLosVideojuegos() {
		// TODO Auto-generated method stub
		return repos.findAll();
	}

	@Override
	public Optional<Videojuego> obtenerVideojuegoPorId(Long id) {
		// TODO Auto-generated method stub
		return repos.findById(id);
	}

	@Override
	public Videojuego añadirVideojuego(Videojuego juego) {
		// TODO Auto-generated method stub
		return repos.save(juego);
	}

	@Override
	public void eliminarVideojuego(Long id) {
		// TODO Auto-generated method stub
		repos.deleteById(id);
	}

	@Override
	public Videojuego actualizarVideojuego(Videojuego juego) {
		// TODO Auto-generated method stub
		return repos.save(juego);
	}

	@Override
	public List<Videojuego> obtenerVideojuegoPorAño(Integer anyo) {
		// TODO Auto-generated method stub
		return repos.findByYear(anyo);
	}

	@Override
	public List<Videojuego> obtenerVideojuegoPorCreador(String creador) {
		// TODO Auto-generated method stub
		return repos.findByDeveloper(creador);
	}

	@Override
	public List<Videojuego> obtenerVideojuegoPorGenero(String genero) {
		// TODO Auto-generated method stub
		System.out.println(genero);
		return repos.findByGenre(genero);
	}

	@Override
	public List<Videojuego> obtenerVideojuegoPorPlataforma(String plataforma) {
		// TODO Auto-generated method stub
		return repos.findByPlatform(plataforma);
	}

	@Override
	public List<Videojuego> obtenerVideojuegoPorOnline(boolean online) {
		// TODO Auto-generated method stub
		return repos.findByOnline(online);
	}

	@Override
	public Optional<Videojuego> obtenerVideojuegoPorNombre(String nombre) {
		// TODO Auto-generated method stub
		return repos.findByTitle(nombre);
	}

	@Override
	public Videojuego obtenerJuegoID(Long id) {
		// TODO Auto-generated method stub
		return repos.findByID(id);
	}

	@Override
	public Videojuego obtenerVideojuegoPorSuNombre(String nombre) {
		// TODO Auto-generated method stub
		return repos.findTheName(nombre);
	}

}
