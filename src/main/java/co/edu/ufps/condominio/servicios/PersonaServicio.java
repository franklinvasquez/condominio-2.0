package co.edu.ufps.condominio.servicios;

import co.edu.ufps.condominio.entity.Persona;
import co.edu.ufps.condominio.modelo.formPerfil;
import co.edu.ufps.condominio.util.Respuesta;

public interface PersonaServicio {
	
	public abstract Respuesta<String> registrar(Persona persona);
	public abstract Respuesta<String> actualizar(formPerfil frm);
	public abstract Persona buscar(String id);
}
