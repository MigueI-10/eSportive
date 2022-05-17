package com.proyecto.esportive.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proyecto.esportive.entities.ClubJugador;
import com.proyecto.esportive.entities.Jugador;
import com.proyecto.esportive.repository.JugadorRepository;

@Service
public class JugadorServiceImpl implements JugadorServiceI{

	@Autowired
	private JugadorRepository repos;

	@Override
	public List<Jugador> obtenerTodosLosJugadores() {
		// TODO Auto-generated method stub
		return repos.findAll();
	}

	@Override
	public Optional<Jugador> obtenerJugadorPorId(Long id) {
		// TODO Auto-generated method stub
		return repos.findById(id);
	}

	@Override
	public Jugador obtenerJugadorPorNombre(String nombre) {
		// TODO Auto-generated method stub
		return repos.findByName(nombre);
	}

	@Override
	public Jugador añadirJugador(Jugador jugador) {
		// TODO Auto-generated method stub
		return repos.save(jugador);
	}

	@Override
	public void eliminarJugador(Long id) {
		// TODO Auto-generated method stub
		repos.deleteById(id);
	}

	@Override
	public Jugador actualizarJugador(Jugador jugador) {
		// TODO Auto-generated method stub
		return repos.save(jugador);
	}

	@Override
	public List<Jugador> obtenerJugadorPorApellido(String apellido) {
		// TODO Auto-generated method stub
		return repos.findBySurname(apellido);
	}

	@Override
	public List<Jugador> obtenerJugadorPorNickname(String nickname) {
		// TODO Auto-generated method stub
		return repos.findByNickname(nickname);
	}

	@Override
	public List<Jugador> obtenerJugadorPorPais(String pais) {
		// TODO Auto-generated method stub
		return repos.findByCountry(pais);
	}

	@Override
	public List<Jugador> obtenerJugadorPorVictoriasMas(Integer victorias) {
		// TODO Auto-generated method stub
		return repos.findByVictoriesMax(victorias);
	}
	
	@Override
	public List<Jugador> obtenerJugadorPorVictoriasMenos(Integer victorias) {
		// TODO Auto-generated method stub
		return repos.findByVictoriesMin(victorias);
	}

	@Override
	public List<Jugador> obtenerJugadorPorSalarioMas(Double salario) {
		// TODO Auto-generated method stub
		return repos.findBySalaryMax(salario);
	}

	@Override
	public Optional<Jugador> obtenerJugadorNick(String nick) {
		// TODO Auto-generated method stub
		return repos.findNickname(nick);
	}

	@Override
	public Jugador obtenerJugadorID(Long id) {
		// TODO Auto-generated method stub
		return repos.findByID(id);
	}
	
	@Override
	public List<Jugador> obtenerJugadorPorSalarioMenos(Double salario) {
		// TODO Auto-generated method stub
		return repos.findBySalaryMin(salario);
	}

	@Override
	public Jugador obtenerJugadorConNick(String nick) {
		// TODO Auto-generated method stub
		return repos.findByNickName(nick);
	}

	@Override
	public List<Jugador> obtenerPorFechas(String fechaInicio, String fechaFin) {
		// TODO Auto-generated method stub
		return repos.findByDates(fechaInicio, fechaFin);
	}

}
