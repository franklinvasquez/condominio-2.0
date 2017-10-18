package co.edu.ufps.condominio.servicios.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import co.edu.ufps.condominio.entity.Vivienda;
import co.edu.ufps.condominio.repository.ViviendaRepository;
import co.edu.ufps.condominio.servicios.ViviendaServicio;

@Service("ViviendaServicioImpl")
public class ViviendaServicioImpl implements ViviendaServicio {
	
	@Autowired
	@Qualifier("ViviendaRepository")
	private ViviendaRepository viviendaRepository;

	@Override
	public List<Vivienda> listadoByEstado(boolean estado) {
		List<Vivienda>listado =viviendaRepository.findByHabitada(estado);
		return listado;
	}

}
