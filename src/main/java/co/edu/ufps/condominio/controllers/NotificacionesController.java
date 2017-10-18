package co.edu.ufps.condominio.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/notificaciones")
public class NotificacionesController {
	private static final String VIEW_PRINCIPA="notificaciones"
;	
	@GetMapping({"","/"})
	public String showInicio() {
		return VIEW_PRINCIPA;
	}
}
