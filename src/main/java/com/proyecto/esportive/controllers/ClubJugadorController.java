package com.proyecto.esportive.controllers;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;


import com.proyecto.esportive.entities.*;
import com.proyecto.esportive.exceptions.ClubJugadorNotFoundException;
import com.proyecto.esportive.exceptions.JugadorNotFoundException;
import com.proyecto.esportive.repository.ClubJugadorRepository;
import com.proyecto.esportive.services.*;

@RestController
public class ClubJugadorController {

	@Autowired
	private ClubJugadorServiceI service;
	
	@Autowired
	private ClubJugadorRepository repos;
	
	@Autowired
	private JugadorServiceI jugadorService;
	
	@Autowired
	private ClubServiceI clubService;
	
	private List<ClubJugador> lista;
	
	@GetMapping("/clubjugador/listar")
	public ResponseEntity<?> mostrarJuegos() {

		final List<ClubJugador> list = service.obtenerTodosClubJugad();

		if(list.isEmpty()) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No se encontraron registros");
		}else {
			return ResponseEntity.ok(list);
		}
	}
	
	@GetMapping("/clubjugador/{id}")
	public ClubJugador mostrarJugador(@PathVariable Long id) {

		return service.obtenerJugadorPorId(id).orElseThrow(() -> new ClubJugadorNotFoundException(id));
	}
	
	@DeleteMapping("/clubjugador/eliminar/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void eliminarClubJugador(@PathVariable Long id) {

		service.eliminarClubJugPorId(id);

	}

	@PostMapping("/clubjugador/crear")
	@ResponseStatus(HttpStatus.CREATED)
	private ClubJugador aniadirClubjugador(@RequestBody ClubJugador cj) throws Exception {

		return service.aniadirClubJug(cj);
	}

	@PutMapping("/clubjugador/actualizar/{id}")
	public ClubJugador actualizaVideojuego(@RequestBody ClubJugador cj, @PathVariable Long id) {
		
		System.out.println(cj.toString());
		System.out.println(cj.getJugador());
		System.out.println(cj.getClub());
		System.out.println(id);
		
		ClubJugador clubj = service.obtenerClubJugadorID(id);
		
		Jugador j = jugadorService.obtenerJugadorID(cj.getJugador().getId());
		Club c = clubService.obtenerClubID(cj.getClub().getId());
		
		clubj.setClub(c);
		clubj.setJugador(j);
		clubj.setTemporada(cj.getTemporada());
		clubj.setTrofeosIndividuales(cj.getTrofeosIndividuales());
		
		return service.actualizarClubJug(clubj);
	}
	
	
	@GetMapping("/clubjugador/plantilla/{nombre}")
	public ResponseEntity<?> mostrarPlantillaEquipo(@PathVariable String nombre) {

		List<Jugador> jugadores = new ArrayList<>();
		System.out.println(nombre);
		
		Club club = clubService.obtenerNombre(nombre);
		
		if(club == null) {
			System.out.println("es nulo");
			new ClubJugadorNotFoundException(nombre);
		}
		System.out.println("-----------------------------");
	
		Jugador j = null;
	
		lista = club.getClubjugadores();

		for(ClubJugador obj : lista) {
			
			j = obj.getJugador();
			
			jugadores.add(j);
			
		}
		
		if(jugadores.isEmpty()) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No hay jugadores registrados en este equipo");
		}else {
			return ResponseEntity.ok(jugadores);
		}
		
		
	}
	
	@GetMapping("/clubjugador/historia/{nick}")
	public ResponseEntity<?> mostrarHistorialJugador(@PathVariable String nick) {

		List<Club> equipos = new ArrayList<>();
		System.out.println(nick);
		
		Jugador player = jugadorService.obtenerJugadorConNick(nick);
		
		if(player == null) {
			System.out.println("es nulo");
			 new ClubJugadorNotFoundException(nick);
		}
		System.out.println("-----------------------------");
		//System.out.println(club.getPropietario());
		
		Club c = null;

		
		lista = player.getClubjugadores();
		
		
		
		for(ClubJugador obj : lista) {
			
			c = obj.getClub();
			
			equipos.add(c);
			
		}
		

		System.out.println(lista.size());
		if(equipos.isEmpty()) {
			System.out.println("no hay");
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No hay jugadores registrados en este equipo");
		}else {
			return ResponseEntity.ok(equipos);
		}
		
		
	}
	
	@GetMapping("/clubjugador/trofeos/{trofeos}")
	public ResponseEntity<?> mostrarPorTrofeos(@PathVariable Integer trofeos) {

		final List<ClubJugador> list = service.obtenerPorTrofeos(trofeos);

		if(list.isEmpty()) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No hay registros por este numero de trofeos");
		}else {
			return ResponseEntity.ok(list);
		}
	}
	
	@GetMapping("/clubjugador/fechas/{fechaInicio}/{fechaFin}")
	public ResponseEntity<?> mostrarPorFechas(@PathVariable String fechaInicio, @PathVariable String fechaFin) {

		final List<ClubJugador> list = service.obtenerPorFechas(fechaInicio, fechaFin);

		if(list.isEmpty()) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No hay registros por este rango de fechas");
		}else {
			return ResponseEntity.ok(list);
		}
	}
	
	
}
