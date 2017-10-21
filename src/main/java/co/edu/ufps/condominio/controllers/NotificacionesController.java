package co.edu.ufps.condominio.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import co.edu.ufps.condominio.servicios.NotificacionServicio;

@Controller
@RequestMapping("/notificaciones")
public class NotificacionesController {
	private static final String VIEW_PRINCIPA="notificaciones";	
	@Autowired
	@Qualifier("NotificacionServicioImpl")
	private NotificacionServicio notificacionServicio;
	
	@GetMapping({"","/"})
	public String showInicio(Model model) {
		model.addAttribute("notificaciones", notificacionServicio.listar());
		return VIEW_PRINCIPA;
	}
}
