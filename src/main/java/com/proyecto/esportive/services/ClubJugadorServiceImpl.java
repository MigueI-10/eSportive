package com.proyecto.esportive.services;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proyecto.esportive.entities.ClubJugador;
import com.proyecto.esportive.repository.ClubJugadorRepository;

@Service
public class ClubJugadorServiceImpl implements ClubJugadorServiceI {

	@Autowired
	private ClubJugadorRepository repos;

	@Override
	public List<ClubJugador> obtenerTodosClubJugad() {
		// TODO Auto-generated method stub
		return repos.findAll();
	}

	@Override
	public List<ClubJugador> obtenerHistoriaJugador(long id) {
		// TODO Auto-generated method stub
		return repos.findPlayer(id);
	}

	@Override
	public List<ClubJugador> obtenerHistoriaClub(long idClub) {
		// TODO Auto-generated method stub
		return repos.findClub(idClub);
	}

	@Override
	public void eliminarClubJugPorId(long id) {
		// TODO Auto-generated method stub
		repos.deleteById(id);
	}

	@Override
	public ClubJugador aniadirClubJug(ClubJugador clubj) {
		// TODO Auto-generated method stub
		return repos.save(clubj);
	}

	@Override
	public ClubJugador actualizarClubJug(ClubJugador clubj) {
		// TODO Auto-generated method stub
		return repos.save(clubj);
	}

	@Override
	public ClubJugador obtenerClubJugadorID(Long id) {
		// TODO Auto-generated method stub
		return repos.findByID(id);
	}

	@Override
	public Optional<ClubJugador> obtenerJugadorPorId(Long id) {
		// TODO Auto-generated method stub
		return repos.findById(id);
	}

	@Override
	public List<ClubJugador> obtenerPorTrofeos(Integer trofeos) {
		// TODO Auto-generated method stub
		return repos.findByIndividualTrophies(trofeos);
	}

	@Override
	public List<ClubJugador> obtenerPorFechas(String fechaInicio, String fechaFin) {
		// TODO Auto-generated method stub
		return repos.findByDates(fechaInicio, fechaFin);
	}



}
