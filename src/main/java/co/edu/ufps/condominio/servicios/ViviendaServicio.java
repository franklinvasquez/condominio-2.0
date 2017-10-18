package co.edu.ufps.condominio.servicios;

import java.util.List;

import co.edu.ufps.condominio.entity.Vivienda;

public interface ViviendaServicio {
	public List<Vivienda> listadoByEstado(boolean estado);
}
