package co.edu.ufps.condominio.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import co.edu.ufps.condominio.entity.Persona;


@Repository("PersonaRepository")
public interface PersonaRepository extends JpaRepository<Persona, Serializable> {
	
	public abstract boolean existsById(String id);
	public abstract Persona findById(String id);
	
}
