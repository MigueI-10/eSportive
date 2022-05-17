package com.proyecto.esportive.controllers;

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

import com.proyecto.esportive.entities.Club;
import com.proyecto.esportive.entities.Videojuego;
import com.proyecto.esportive.exceptions.ClubNotFoundException;
import com.proyecto.esportive.exceptions.VideojuegoNotFoundException;
import com.proyecto.esportive.services.ClubServiceI;

@RestController
public class ClubController {

	@Autowired
	private ClubServiceI service;
	
	@GetMapping("/club/listar")
	public ResponseEntity<?> mostrarClubes() {

		final List<Club> list = service.obtenerTodosLosClubes();

		if(list.isEmpty()) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No hay clubes registrados");
		}else {
			return ResponseEntity.ok(list);
		}
	}

	@GetMapping("/club/{id}")
	public Club mostrarClub(@PathVariable Long id) {

		return service.obtenerClubPorId(id).orElseThrow(() -> new ClubNotFoundException(id));
	}

	@GetMapping("/club/nombre/{nombre}")
	public Club mostrarClubNombre(@PathVariable String nombre) {

		return service.obtenerClubPorNombre(nombre).orElseThrow(() -> new VideojuegoNotFoundException(nombre));
	}

	@DeleteMapping("/club/eliminar/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void eliminarClub(@PathVariable Long id) {

		service.eliminarClub(id);

	}

	@PostMapping("/club/crear")
	@ResponseStatus(HttpStatus.CREATED)
	private Club aniadirClub(@RequestBody Club c) throws Exception {

		System.out.println(c.toString());
		
		return service.añadirClub(c);
	}

	@PutMapping("/club/actualizar/{id}")
	public Club actualizaClub(@RequestBody Club c, @PathVariable Long id) {
		
		System.out.println(c.toString());
		System.out.println(id);
		
		
		Club vd =  service.obtenerClubID(id);
		
		vd.setNombre(c.getNombre());
		vd.setAnyoCreacion(c.getAnyoCreacion());
		vd.setDescripcion(c.getDescripcion());
		vd.setNumeroTrofeos(c.getNumeroTrofeos());
		vd.setProcedencia(c.getProcedencia());
		vd.setPuntosActuales(c.getPuntosActuales());
		vd.setPropietario(c.getPropietario());
		vd.setVideojuego(c.getVideojuego());
		
		return service.actualizarClub(vd);
	}

	@GetMapping("/club/anyo/{anyo}")
	public ResponseEntity<?> mostrarPorAnyo(@PathVariable Integer anyo) {

		final List<Club> list = service.obtenerPorAño(anyo);

		if(list.isEmpty()) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No hay clubes registrados");
		}else {
			return ResponseEntity.ok(list);
		}
	}
	
	@GetMapping("/club/puntos+/{puntos}")
	public ResponseEntity<?> mostrarPorPuntosMas(@PathVariable Integer puntos) {

		final List<Club> list = service.obtenerPorPuntosMas(puntos);

		if(list.isEmpty()) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No hay clubes registrados");
		}else {
			return ResponseEntity.ok(list);
		}
	}
	
	@GetMapping("/club/puntos-/{puntos}")
	public ResponseEntity<?> mostrarPorPuntosMenos(@PathVariable Integer puntos) {

		final List<Club> list = service.obtenerPorPuntosMenos(puntos);

		if(list.isEmpty()) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No hay clubes registrados");
		}else {
			return ResponseEntity.ok(list);
		}
	}
	
	@GetMapping("/club/trofeos+/{trofeos}")
	public ResponseEntity<?> mostrarPorTrofeosMas(@PathVariable Integer trofeos) {

		final List<Club> list = service.obtenerPorTrofeosMas(trofeos);

		if(list.isEmpty()) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No hay clubes registrados");
		}else {
			return ResponseEntity.ok(list);
		}
	}
	
	@GetMapping("/club/trofeos-/{trofeos}")
	public ResponseEntity<?> mostrarPorTrofeosMenos(@PathVariable Integer trofeos) {

		final List<Club> list = service.obtenerPorTrofeosMenos(trofeos);

		if(list.isEmpty()) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No hay clubes registrados");
		}else {
			return ResponseEntity.ok(list);
		}
	}

	@GetMapping("/club/propietario/{prop}")
	public ResponseEntity<?> mostrarPorDesarrolladora(@PathVariable String prop) {

		final List<Club> list = service.obtenerPorPropietario(prop);

		if(list.isEmpty()) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No hay clubes registrados");
		}else {
			return ResponseEntity.ok(list);
		}
	}

	@GetMapping("/club/pais/{pais}")
	public ResponseEntity<?> mostrarPorPais(@PathVariable String pais) {

		final List<Club> list = service.obtenerPorPais(pais);

		if(list.isEmpty()) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No hay clubes registrados");
		}else {
			return ResponseEntity.ok(list);
		}
	}

	
	
}
