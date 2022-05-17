package com.proyecto.esportive.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proyecto.esportive.entities.Club;
import com.proyecto.esportive.repository.ClubRepository;

@Service
public class ClubServiceImpl implements ClubServiceI{

	@Autowired
	private ClubRepository repos;

	@Override
	public List<Club> obtenerTodosLosClubes() {
		// TODO Auto-generated method stub
		return repos.findAll();
	}

	@Override
	public Optional<Club> obtenerClubPorId(Long id) {
		// TODO Auto-generated method stub
		return repos.findById(id);
	}

	@Override
	public Club añadirClub(Club club) {
		// TODO Auto-generated method stub
		return repos.save(club);
	}

	@Override
	public void eliminarClub(Long id) {
		// TODO Auto-generated method stub
		repos.deleteById(id);
	}

	@Override
	public Club actualizarClub(Club club) {
		// TODO Auto-generated method stub
		return repos.save(club);
	}

	@Override
	public List<Club> obtenerPorPropietario(String owner) {
		// TODO Auto-generated method stub
		return repos.findByOwner(owner);
	}

	@Override
	public List<Club> obtenerPorPais(String pais) {
		// TODO Auto-generated method stub
		return repos.findByCountry(pais);
	}

	@Override
	public List<Club> obtenerPorAño(Integer anyo) {
		// TODO Auto-generated method stub
		return repos.findByAnyo(anyo);
	}

	@Override
	public Optional<Club> obtenerClubPorNombre(String nombre) {
		// TODO Auto-generated method stub
		return repos.findByName(nombre);
	}

	@Override
	public Club obtenerClubID(Long id) {
		// TODO Auto-generated method stub
		return repos.findByID(id);
	}

	@Override
	public Club obtenerNombre(String nombre) {
		// TODO Auto-generated method stub
		return repos.findNameClub(nombre);
	}

	@Override
	public List<Club> obtenerPorPuntosMas(Integer puntos) {
		// TODO Auto-generated method stub
		return repos.findByPointsMax(puntos);
	}

	@Override
	public List<Club> obtenerPorPuntosMenos(Integer puntos) {
		// TODO Auto-generated method stub
		return repos.findByPointsMin(puntos);
	}

	@Override
	public List<Club> obtenerPorTrofeosMas(Integer trofeos) {
		// TODO Auto-generated method stub
		return repos.findByTrophiesMax(trofeos);
	}

	@Override
	public List<Club> obtenerPorTrofeosMenos(Integer trofeos) {
		// TODO Auto-generated method stub
		return repos.findByTrophiesMin(trofeos);
	}



}
