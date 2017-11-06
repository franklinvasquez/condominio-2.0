package co.edu.ufps.condominio.repository;

import java.io.Serializable;
import java.util.List;
import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import co.edu.ufps.condominio.entity.DestinatarioNotificacion;
import co.edu.ufps.condominio.entity.Vivienda;

@Repository("DestinatarioNotificacionRepository")
public interface DestinatarioNotificacionRepository extends JpaRepository<DestinatarioNotificacion, Serializable> {
	@Query("select u from DestinatarioNotificacion u where u.id.vivienda in (:listado)")
	public List<DestinatarioNotificacion>findQuery(@Param("listado")Set<Vivienda> listado);
}
