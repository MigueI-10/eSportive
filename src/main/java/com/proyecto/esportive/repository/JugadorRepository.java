package com.proyecto.esportive.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.proyecto.esportive.entities.ClubJugador;
import com.proyecto.esportive.entities.Jugador;

public interface JugadorRepository extends JpaRepository<Jugador ,Long>{

	@Query(value = "SELECT * FROM jugador WHERE id = ?", nativeQuery = true)
	Jugador findByID(Long id);

	@Query(value = "SELECT * FROM jugador WHERE nickname = ?", nativeQuery = true)
	Optional<Jugador> findNickname(String nickname);
	
	@Query(value = "SELECT * FROM jugador WHERE nombre = ?", nativeQuery = true)
	Jugador findByName(String name);
	
	@Query(value = "SELECT * FROM jugador WHERE nickname = ?", nativeQuery = true)
	Jugador findByNickName(String name);

	@Query(value = "SELECT * FROM jugador WHERE apellido = ?", nativeQuery = true)
	List<Jugador> findBySurname(String surname);

	@Query(value = "SELECT * FROM jugador WHERE nickname = ?", nativeQuery = true)
	List<Jugador> findByNickname(String nickname);

	@Query(value = "SELECT * FROM jugador WHERE nacionalidad = ?", nativeQuery = true)
	List<Jugador> findByCountry(String country);

	@Query(value = "SELECT * FROM jugador WHERE max_victorias > ?", nativeQuery = true)
	List<Jugador> findByVictoriesMax(Integer victories);
	
	@Query(value = "SELECT * FROM jugador WHERE max_victorias < ?", nativeQuery = true)
	List<Jugador> findByVictoriesMin(Integer victories);

	@Query(value = "SELECT * FROM jugador WHERE salario > ?", nativeQuery = true)
	List<Jugador> findBySalaryMax(Double salary);

	@Query(value = "SELECT * FROM jugador WHERE salario < ?", nativeQuery = true)
	List<Jugador> findBySalaryMin(Double salary);
	
	@Query(value = "SELECT * FROM jugador WHERE fecha_nac BETWEEN ?1 AND ?2", nativeQuery = true)
	List<Jugador> findByDates(String fechaInicio, String fechaFin);
}
