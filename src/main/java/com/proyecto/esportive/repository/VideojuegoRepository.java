package com.proyecto.esportive.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.proyecto.esportive.entities.Videojuego;

@Repository
public interface VideojuegoRepository extends JpaRepository<Videojuego,Long>{

	@Query(value = "SELECT * FROM videojuego WHERE id = ?", nativeQuery = true)
	Videojuego findByID(Long id);

	@Query(value = "SELECT * FROM videojuego WHERE nombre = ?", nativeQuery = true)
	Optional<Videojuego> findByTitle(String title);

	@Query(value = "SELECT * FROM videojuego WHERE nombre = ?", nativeQuery = true)
	Videojuego findTheName(String nombre);
	
	@Query(value = "SELECT * FROM videojuego WHERE anyo_salida = ?", nativeQuery = true)
	List<Videojuego> findByYear(Integer anyo);

	@Query(value = "SELECT * FROM videojuego WHERE desarrolladora = ?1", nativeQuery = true)
	List<Videojuego> findByDeveloper(String developer);

	@Query(value = "SELECT * FROM Videojuego WHERE genero = ?1", nativeQuery = true)
	List<Videojuego> findByGenre(String genre);

	@Query(value = "SELECT * FROM videojuego WHERE online = ?", nativeQuery = true)
	List<Videojuego> findByOnline(boolean online);

	@Query(value = "SELECT * FROM videojuego WHERE plataforma = ?1", nativeQuery = true)
	List<Videojuego> findByPlatform(String platform);
}
