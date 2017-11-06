package co.edu.ufps.condominio.repository;

import java.io.Serializable;
import java.util.List;
import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import co.edu.ufps.condominio.entity.Vivienda;

@Repository("ViviendaRepository")
public interface ViviendaRepository extends JpaRepository<Vivienda, Serializable>{
	public abstract List<Vivienda> findByHabitada(boolean estado);
	public abstract Vivienda findById(int id);
	public abstract List<Vivienda> findByIdIn(Set<Integer> param);
}
