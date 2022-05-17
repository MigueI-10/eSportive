package com.proyecto.esportive.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.proyecto.esportive.entities.Club;

public interface ClubRepository extends JpaRepository<Club,Long>{

	@Query(value = "SELECT * FROM club WHERE id = ?", nativeQuery = true)
	Club findByID(Long id);

	@Query(value = "SELECT * FROM club WHERE nombre = ?", nativeQuery = true)
	Optional<Club> findByName(String name);
	
	@Query(value = "SELECT * FROM club WHERE nombre = ?", nativeQuery = true)
	Club findNameClub(String name);

	@Query(value = "SELECT * FROM club WHERE propietario = ?", nativeQuery = true)
	List<Club> findByOwner(String owner);

	@Query(value = "SELECT * FROM club WHERE procedencia = ?", nativeQuery = true)
	List<Club> findByCountry(String country);

	@Query(value = "SELECT * FROM club WHERE anyo_creacion = ?", nativeQuery = true)
	List<Club> findByAnyo(Integer anyo);

	@Query(value = "SELECT * FROM club WHERE puntos_actuales > ?", nativeQuery = true)
	List<Club> findByPointsMax(Integer points);
	
	@Query(value = "SELECT * FROM club WHERE puntos_actuales < ?", nativeQuery = true)
	List<Club> findByPointsMin(Integer points);

	@Query(value = "SELECT * FROM club WHERE numero_trofeos > ?", nativeQuery = true)
	List<Club> findByTrophiesMax(Integer trophies);
	
	@Query(value = "SELECT * FROM club WHERE numero_trofeos < ?", nativeQuery = true)
	List<Club> findByTrophiesMin(Integer trophies);

}
