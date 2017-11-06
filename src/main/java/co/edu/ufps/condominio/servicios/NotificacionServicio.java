package co.edu.ufps.condominio.servicios;

import java.util.List;
import java.util.Set;

import co.edu.ufps.condominio.entity.Persona;
import co.edu.ufps.condominio.entity.Vivienda;
import co.edu.ufps.condominio.modelo.FormNotificaciones;
import co.edu.ufps.condominio.modelo.NotaNotificacion;
import co.edu.ufps.condominio.util.Respuesta;

public interface NotificacionServicio {
	public abstract List<NotaNotificacion>listar(Persona persona);
	public abstract Respuesta<String> registrar(FormNotificaciones form);
	public abstract Respuesta<Set<Vivienda>> prueba(Persona persona);
}
