package co.edu.ufps.condominio.servicios.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import co.edu.ufps.condominio.entity.Notificacion;
import co.edu.ufps.condominio.repository.NotificacionRepository;
import co.edu.ufps.condominio.servicios.NotificacionServicio;
@Service("NotificacionServicioImpl")
public class NotificacionServicioImpl implements NotificacionServicio {

	@Autowired
	@Qualifier("NotificacionRepository")
	private NotificacionRepository notificacionRepository;
	
	@Override
	public List<Notificacion> listar() {
		return notificacionRepository.findAll();
	}

}
