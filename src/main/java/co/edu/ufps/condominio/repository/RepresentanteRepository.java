package co.edu.ufps.condominio.repository;

import java.io.Serializable;
import java.util.List;
import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import co.edu.ufps.condominio.entity.Persona;
import co.edu.ufps.condominio.entity.Representante;
import co.edu.ufps.condominio.entity.Vivienda;

@Repository("RepresentanteRepository")
public interface RepresentanteRepository extends JpaRepository<Representante, Serializable> {
	public abstract Representante findById(int id);


	//@Query("SELECT r FROM Representante r WHERE r.persona=:id and r.fechaFin IS NULL")
	public abstract List<Representante> findByPersonaAndFechaFinalIsNull(Persona persona);
	
	@Query("select u.vivienda from Representante u where u.persona=:perso and u.fechaFinal is null")
	public abstract Set<Vivienda>findQueryVivienda(@Param("perso") Persona persona);
}
