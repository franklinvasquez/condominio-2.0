package co.edu.ufps.condominio.servicios.impl;

import java.util.ArrayList;
import java.util.Calendar;
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
import co.edu.ufps.condominio.repository.NotificacionRepository;
import co.edu.ufps.condominio.repository.RepresentanteRepository;
import co.edu.ufps.condominio.repository.ViviendaRepository;
import co.edu.ufps.condominio.servicios.NotificacionServicio;
import co.edu.ufps.condominio.util.Respuesta;
@Service("NotificacionServicioImpl")
public class NotificacionServicioImpl implements NotificacionServicio {
	private Log log = LogFactory.getLog(NotificacionServicioImpl.class);

	@Autowired
	@Qualifier("DestinatarioNotificacionRepository")
	private DestinatarioNotificacionRepository destinatarioNotiRepository;
	
	@Autowired
	@Qualifier("ViviendaRepository")
	ViviendaRepository viviendaRepository;
	
	@Autowired
	@Qualifier("RepresentanteRepository")
	private RepresentanteRepository representanteRepository;
	
	@Autowired
	@Qualifier("NotificacionRepository")
	private NotificacionRepository notificacionRepository;
	


	@Override
	public Respuesta<String> registrar(FormNotificaciones form) {
	   Respuesta<String> ret = new Respuesta<String>(false, "Error al registrar");
		Notificacion notificacionEntity= new Notificacion();
		notificacionEntity.setFechaPublicacion(Calendar.getInstance());
		notificacionEntity.setFechaEvento(form.getFechaEvento());
		notificacionEntity.setTitulo(form.getTitulo());
		notificacionEntity.setInformacion(form.getCuerpo());
		notificacionEntity.setTipo('N');
		notificacionEntity=notificacionRepository.save(notificacionEntity);
		if(notificacionEntity!=null) {
			List<Vivienda>viviendas=viviendaRepository.findByIdIn(form.getViviendas());
			List<DestinatarioNotificacion> listadoDestinatario= new ArrayList<>(viviendas.size());
			for(Vivienda vivienda:viviendas) {
				DestinatarioNotificacion destinatarioEntity = new DestinatarioNotificacion();
				destinatarioEntity.setLectura(false);
				//llave primaria
				DestinatarioNotificacionPK destinatarioKey = new DestinatarioNotificacionPK();
				destinatarioKey.setVivienda(vivienda);
				destinatarioKey.setNotificacion(notificacionEntity);			
				destinatarioEntity.setId(destinatarioKey);
				listadoDestinatario.add(destinatarioEntity);			
			}
		 if(destinatarioNotiRepository.save(listadoDestinatario)!=null) {
			 ret.setEstado(true);
			 ret.setValor("Registro exitoso");
		 }
		}
		return ret;
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
