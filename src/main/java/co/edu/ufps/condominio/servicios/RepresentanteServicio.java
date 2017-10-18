package co.edu.ufps.condominio.servicios;

import java.util.List;

import co.edu.ufps.condominio.entity.Representante;
import co.edu.ufps.condominio.modelo.FormRepresentante;
import co.edu.ufps.condominio.util.Respuesta;

public interface RepresentanteServicio {
	public abstract Respuesta<String> registrar(FormRepresentante form);
	public abstract Respuesta<String> desactivar(int id);
	public abstract FormRepresentante buscar(int id);
	public abstract List<Representante> listar();
}
