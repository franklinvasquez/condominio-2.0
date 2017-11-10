package co.edu.ufps.condominio.controllers;

import java.util.Set;

import javax.validation.Valid;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import co.edu.ufps.condominio.entity.Vivienda;
import co.edu.ufps.condominio.modelo.FormNotificaciones;
import co.edu.ufps.condominio.servicios.NotificacionServicio;
import co.edu.ufps.condominio.servicios.PersonaServicio;
import co.edu.ufps.condominio.servicios.ViviendaServicio;
import co.edu.ufps.condominio.util.Respuesta;

@Controller
@RequestMapping("/notificaciones")
public class NotificacionesController {
	private static final String VIEW_PRINCIPA="notificaciones";	
	private Log log = LogFactory.getLog(NotificacionesController.class);
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
	
	@PostMapping("/registrar")
	public @ResponseBody Respuesta<String>registrar(@ModelAttribute @Valid FormNotificaciones form,BindingResult result){
		Respuesta<String>response = new Respuesta<String>();
		if(!result.hasErrors()) {
			response=notificacionServicio.registrar(form);
		}
		else {
			response.setEstado(false);
			response.setValor("error en el formulario");
			response.calcularMap(result.getFieldErrors());
		}
		
		return response;
	}
	
	@GetMapping("prueba")
	public @ResponseBody Respuesta<Set<Vivienda>> testRepresentante() {
		User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	    String name = user.getUsername();
	    Respuesta<Set<Vivienda>>listado= notificacionServicio.prueba(personaServicio.buscar(name));
		return listado;
	}
	
	@GetMapping("/refresh-editor")
	public String refreshEditor(Model model) {
		model.addAttribute("viviendas", viviendaServicio.listadoByEstado(true));
		return "fragmentos/notas::editor";
	}
	
	@GetMapping("/refresh-visor")
	public String refreshVisor() {
		return "fragmentos/notas::visor";
	}
	@GetMapping("/refresh-listado")
	public String refreshlistado() {
		return VIEW_PRINCIPA+"::listado-notas";
	}
	
	
}
