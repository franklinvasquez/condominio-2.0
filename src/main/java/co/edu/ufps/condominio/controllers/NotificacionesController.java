package co.edu.ufps.condominio.controllers;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import co.edu.ufps.condominio.entity.Vivienda;
import co.edu.ufps.condominio.servicios.NotificacionServicio;
import co.edu.ufps.condominio.servicios.PersonaServicio;
import co.edu.ufps.condominio.servicios.ViviendaServicio;
import co.edu.ufps.condominio.util.Respuesta;

@Controller
@RequestMapping("/notificaciones")
public class NotificacionesController {
	private static final String VIEW_PRINCIPA="notificaciones";	
	@Autowired
	@Qualifier("NotificacionServicioImpl")
	private NotificacionServicio notificacionServicio;
	
	@Autowired
	@Qualifier("ViviendaServicioImpl")
	private ViviendaServicio viviendaServicio;
	
	@Autowired
	@Qualifier("PersonaServicioImpl")
	private PersonaServicio personaServicio;
	
	@GetMapping({"","/"})
	public String showInicio(Model model) {
		User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	    String name = user.getUsername();
		model.addAttribute("notificaciones", notificacionServicio.listar(personaServicio.buscar(name)));
		model.addAttribute("viviendas", viviendaServicio.listadoByEstado(true));
		return VIEW_PRINCIPA;
	}
	
	@GetMapping("prueba")
	public @ResponseBody Respuesta<Set<Vivienda>> testRepresentante() {
		User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	    String name = user.getUsername();
	    Respuesta<Set<Vivienda>>listado= notificacionServicio.prueba(personaServicio.buscar(name));
		return listado;
	}
}
