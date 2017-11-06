package co.edu.ufps.condominio.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import co.edu.ufps.condominio.entity.Notificacion;

@Repository("NotificacionRepository")
public interface NotificacionRepository extends JpaRepository<Notificacion, Serializable> {
}
