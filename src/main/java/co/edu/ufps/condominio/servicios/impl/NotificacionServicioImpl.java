package co.edu.ufps.condominio.servicios.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import co.edu.ufps.condominio.entity.DestinatarioNotificacion;
import co.edu.ufps.condominio.entity.DestinatarioNotificacionPK;
import co.edu.ufps.condominio.entity.Notificacion;
import co.edu.ufps.condominio.entity.Persona;
import co.edu.ufps.condominio.entity.Vivienda;
import co.edu.ufps.condominio.modelo.FormNotificaciones;
import co.edu.ufps.condominio.modelo.NotaNotificacion;
import co.edu.ufps.condominio.repository.DestinatarioNotificacionRepository;
import co.edu.ufps.condominio.repository.RepresentanteRepository;
import co.edu.ufps.condominio.servicios.NotificacionServicio;
import co.edu.ufps.condominio.util.Respuesta;
@Service("NotificacionServicioImpl")
public class NotificacionServicioImpl implements NotificacionServicio {
	private Log log = LogFactory.getLog(NotificacionServicioImpl.class);

	@Autowired
	@Qualifier("DestinatarioNotificacionRepository")
	private DestinatarioNotificacionRepository destinatarioNotiRepository;
	
	
	@Autowired
	@Qualifier("RepresentanteRepository")
	private RepresentanteRepository representanteRepository;
	


	@Override
	public Respuesta<String> registrar(FormNotificaciones form) {	
		return null;
	}

	@Override
	public Respuesta<Set<Vivienda>> prueba(Persona persona) {
		Respuesta<Set<Vivienda>> ret = new Respuesta<>();
		ret.setEstado(true);
		//ret.setValor(representanteRepository.findQueryVivienda(persona));
		return ret;
	}

	@Override
	public List<NotaNotificacion> listar(Persona persona) {
		Set<Vivienda> viviendas=representanteRepository.findQueryVivienda(persona);	
		List<DestinatarioNotificacion>listado=destinatarioNotiRepository.findQuery(viviendas);
		log.info("tamaño : "+listado.size());
		List<NotaNotificacion> listadoNotas = new ArrayList<>();
		for(DestinatarioNotificacion destinatario:listado) {
			DestinatarioNotificacionPK pk = destinatario.getId();
			Notificacion notificacion= pk.getNotificacion();
			NotaNotificacion nota = new NotaNotificacion();
			//
			nota.setEstado(destinatario.isLectura());
			nota.setFecha(notificacion.getFechaPublicacion());
			
			nota.setMensaje(notificacion.getInformacion());
			nota.setTitulo(notificacion.getTitulo());
			nota.setNombreVivienda(pk.getVivienda().getNumero());
			listadoNotas.add(nota);
		}
		return listadoNotas;
	}
}
