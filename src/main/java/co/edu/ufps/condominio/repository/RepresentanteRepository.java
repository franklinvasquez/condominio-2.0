package co.edu.ufps.condominio.repository;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import co.edu.ufps.condominio.entity.Persona;
import co.edu.ufps.condominio.entity.Representante;

@Repository("RepresentanteRepository")
public interface RepresentanteRepository extends JpaRepository<Representante, Serializable> {
	public abstract Representante findById(int id);


	//@Query("SELECT r FROM Representante r WHERE r.persona=:id and r.fechaFin IS NULL")
	public abstract List<Representante> findByPersonaAndFechaFinalIsNull(Persona persona);
}
