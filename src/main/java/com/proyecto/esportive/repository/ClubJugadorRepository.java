package com.proyecto.esportive.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.proyecto.esportive.entities.Club;
import com.proyecto.esportive.entities.ClubJugador;
import com.proyecto.esportive.entities.Jugador;

public interface ClubJugadorRepository extends JpaRepository<ClubJugador,Long>{

	@Query(value = "SELECT * FROM club_jugador WHERE id = ?", nativeQuery = true)
	ClubJugador findByID(Long id);
	
	@Query(value = "SELECT * FROM club_jugador WHERE jugador_id = ?", nativeQuery = true)
	List <ClubJugador> findPlayer(Long Id);

	/***
	 * Metodo que devuelve una lista de equipos- futbolistas a partir de su id de equipo
	 * @param Id del equipo a buscar
	 * @return la lista de equipos futbolistas
	 */
	@Query(value = "SELECT * FROM club_jugador WHERE club_id = ?", nativeQuery = true)
	List <ClubJugador> findClub(Long Id);
	
	@Query(value = "SELECT * FROM club_jugador WHERE trofeos_individuales > ?", nativeQuery = true)
	List<ClubJugador> findByIndividualTrophies(Integer trophies);

	@Query(value = "SELECT * FROM club_jugador WHERE temporada BETWEEN ?1 AND ?2", nativeQuery = true)
	List<ClubJugador> findByDates(String fechaInicio, String fechaFin);
}
