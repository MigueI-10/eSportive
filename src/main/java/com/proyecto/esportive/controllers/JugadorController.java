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
import com.proyecto.esportive.entities.ClubJugador;
import com.proyecto.esportive.entities.Jugador;
import com.proyecto.esportive.exceptions.ClubNotFoundException;
import com.proyecto.esportive.exceptions.JugadorNotFoundException;
import com.proyecto.esportive.exceptions.VideojuegoNotFoundException;
import com.proyecto.esportive.services.JugadorServiceI;

@RestController
public class JugadorController {

	@Autowired
	private JugadorServiceI service;
	
	@GetMapping("/jugador/listar")
	public ResponseEntity<?> mostrarJugadores() {

		final List<Jugador> list = service.obtenerTodosLosJugadores();

		if(list.isEmpty()) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No hay jugadores registrados");
		}else {
			return ResponseEntity.ok(list);
		}
	}

	@GetMapping("/jugador/{id}")
	public Jugador mostrarJugador(@PathVariable Long id) {

		return service.obtenerJugadorPorId(id).orElseThrow(() -> new JugadorNotFoundException(id));
	}

	@GetMapping("/jugador/nick/{nick}")
	public Jugador mostrarClubNombre(@PathVariable String nick) {

		return service.obtenerJugadorNick(nick).orElseThrow(() -> new JugadorNotFoundException(nick));
	}

	@DeleteMapping("/jugador/eliminar/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void eliminarJugador(@PathVariable Long id) {

		service.eliminarJugador(id);
	}

	@PostMapping("/jugador/crear")
	@ResponseStatus(HttpStatus.CREATED)
	private Jugador aniadirJugador(@RequestBody Jugador j) throws Exception {

		System.out.println(j.toString());
		
		return service.añadirJugador(j);
	}

	@PutMapping("/jugador/actualizar/{id}")
	public Jugador actualizaJugador(@RequestBody Jugador j, @PathVariable Long id) {
		
		System.out.println(j.toString());
		System.out.println(id);
		
		Jugador jg =  service.obtenerJugadorID(id);
		jg.setNombre(j.getNombre());	
		jg.setFechaNac(j.getFechaNac());
		jg.setApellido(j.getApellido());
		jg.setMaxVictorias(j.getMaxVictorias());
		jg.setNacionalidad(j.getNacionalidad());
		jg.setNickname(j.getNickname());
		jg.setSalario(j.getSalario());

		return service.actualizarJugador(jg);
	}

	
	@GetMapping("/jugador/victorias+/{vict}")
	public ResponseEntity<?> mostrarPorVictoriasMas(@PathVariable Integer vict) {

		final List<Jugador> list = service.obtenerJugadorPorVictoriasMas(vict);

		if(list.isEmpty()) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No hay jugadores registrados");
		}else {
			return ResponseEntity.ok(list);
		}
	}
	
	@GetMapping("/jugador/victorias-/{vict}")
	public ResponseEntity<?> mostrarPorVictoriasMenos(@PathVariable Integer vict) {

		final List<Jugador> list = service.obtenerJugadorPorVictoriasMenos(vict);

		if(list.isEmpty()) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No hay jugadores registrados");
		}else {
			return ResponseEntity.ok(list);
		}
	}
	
	@GetMapping("/jugador/salario+/{salario}")
	public ResponseEntity<?> mostrarPorSalarioMas(@PathVariable Double salario) {

		final List<Jugador> list = service.obtenerJugadorPorSalarioMas(salario);

		if(list.isEmpty()) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No hay jugadores registrados");
		}else {
			return ResponseEntity.ok(list);
		}
	}
	
	@GetMapping("/jugador/salario-/{salario}")
	public ResponseEntity<?> mostrarPorSalarioMenos(@PathVariable Double salario) {

		final List<Jugador> list = service.obtenerJugadorPorSalarioMenos(salario);

		if(list.isEmpty()) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No hay jugadores registrados");
		}else {
			return ResponseEntity.ok(list);
		}
	}

	/* @GetMapping("/jugador/apellido/{ape}")
	public ResponseEntity<?> mostrarPorApellido(@PathVariable String ape) {

		final List<Jugador> list = service.obtenerJugadorPorApellido(ape);

		if(list.isEmpty()) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No hay jugadores registrados");
		}else {
			return ResponseEntity.ok(list);
		}
	}*/

	@GetMapping("/jugador/pais/{pais}")
	public ResponseEntity<?> mostrarPorPais(@PathVariable String pais) {

		final List<Jugador> list = service.obtenerJugadorPorPais(pais);

		if(list.isEmpty()) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No hay jugadores registrados");
		}else {
			return ResponseEntity.ok(list);
		}
	}
	
	@GetMapping("/jugador/fechas/{fechaInicio}/{fechaFin}")
	public ResponseEntity<?> mostrarPorFechas(@PathVariable String fechaInicio, @PathVariable String fechaFin) {

		final List<Jugador> list = service.obtenerPorFechas(fechaInicio, fechaFin);

		if(list.isEmpty()) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No hay registros por este rango de fechas");
		}else {
			return ResponseEntity.ok(list);
		}
	}
	
}
