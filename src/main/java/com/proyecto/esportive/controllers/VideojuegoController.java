package com.proyecto.esportive.controllers;

import java.util.ArrayList;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.proyecto.esportive.entities.Videojuego;
import com.proyecto.esportive.exceptions.VideojuegoNotFoundException;
import com.proyecto.esportive.services.VideojuegoServiceI;

@RestController
public class VideojuegoController {

	@Autowired
	private VideojuegoServiceI service;

	@GetMapping("/conexion")
	public ResponseEntity<?> pruebaConexion() {

		final List<String> list = new ArrayList<>();

		list.add("Prueba");
		
		if(list.isEmpty()) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No hay videojuegos registrados");
		}else {
			return ResponseEntity.ok(list);
		}
	}
	
	
	@GetMapping("/videojuego/listar")
	public ResponseEntity<?> mostrarJuegos() {

		final List<Videojuego> list = service.obtenerTodosLosVideojuegos();

		if(list.isEmpty()) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No hay videojuegos registrados");
		}else {
			return ResponseEntity.ok(list);
		}
	}

	@GetMapping("/videojuego/{id}")
	public Videojuego mostrarJuego(@PathVariable Long id) {

		return service.obtenerVideojuegoPorId(id).orElseThrow(() -> new VideojuegoNotFoundException(id));
	}

	@GetMapping("/videojuego/nombre/{nombre}")
	public Videojuego mostrarJuegoNombre(@PathVariable String nombre) {

		return service.obtenerVideojuegoPorNombre(nombre).orElseThrow(() -> new VideojuegoNotFoundException(nombre));
	}
	
	@GetMapping("/videojuego/getnombre/{nombre}")
	public Videojuego mostrarJuegoPorSuNombre(@PathVariable String nombre) {

		return service.obtenerVideojuegoPorSuNombre(nombre);
	}

	@DeleteMapping("/videojuego/eliminar/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void eliminarVideojuego(@PathVariable Long id) {

		service.eliminarVideojuego(id);

	}

	@PostMapping("/videojuego/crear")
	@ResponseStatus(HttpStatus.CREATED)
	private Videojuego aniadirVideojuego(@RequestBody Videojuego game) throws Exception {

		return service.añadirVideojuego(game);
	}

	@PutMapping("/videojuego/actualizar/{id}")
	public Videojuego actualizaVideojuego(@RequestBody Videojuego v, @PathVariable Long id) {
		
		System.out.println(v.toString());
		Videojuego vd = service.obtenerJuegoID(id);
		
		vd.setNombre(v.getNombre());
		vd.setDesarrolladora(v.getDesarrolladora());
		vd.setAnyoSalida(v.getAnyoSalida());
		vd.setDescripcion(v.getDescripcion());
		vd.setGenero(v.getGenero());
		vd.setPlataforma(v.getPlataforma());
		vd.setOnline(v.isOnline());
		
		return service.actualizarVideojuego(vd);
	}

	@GetMapping("/videojuego/anyo/{anyo}")
	public ResponseEntity<?> mostrarPorAnyo(@PathVariable Integer anyo) {

		final List<Videojuego> list = service.obtenerVideojuegoPorAño(anyo);

		if(list.isEmpty()) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No hay videojuegos registrados");
		}else {
			return ResponseEntity.ok(list);
		}
	}

	@GetMapping("/videojuego/desarrolladora/{desarrolladora}")
	public ResponseEntity<?> mostrarPorDesarrolladora(@PathVariable String desarrolladora) {

		System.out.println(desarrolladora);
		
		final List<Videojuego> list = service.obtenerVideojuegoPorCreador(desarrolladora);

		if(list.isEmpty()) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No hay videojuegos registrados");
		}else {
			return ResponseEntity.ok(list);
		}
	}

	@GetMapping("/videojuego/genero/{genero}")
	public ResponseEntity<?> mostrarPorGenero(@PathVariable String genero) {

		final List<Videojuego> list = service.obtenerVideojuegoPorGenero(genero);

		if(list.isEmpty()) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No hay videojuegos registrados");
		}else {
			return ResponseEntity.ok(list);
		}
	}

	@GetMapping("/videojuego/plataforma/{plataforma}")
	public ResponseEntity<?> mostrarPorPlataforma(@PathVariable String plataforma) {

		final List<Videojuego> list = service.obtenerVideojuegoPorPlataforma(plataforma);

		if(list.isEmpty()) {
			System.out.println("no hay registros");
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No hay videojuegos registrados");
		}else {
			return ResponseEntity.ok(list);
		}
	}

	@GetMapping("/videojuego/online/{online}")
	public ResponseEntity<?> mostrarPorOnline(@PathVariable boolean online) {

		System.out.println(online);
		
		final List<Videojuego> list = service.obtenerVideojuegoPorOnline(online);

		if(list.isEmpty()) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No hay videojuegos registrados");
		}else {
			return ResponseEntity.ok(list);
		}
	}
}
