package co.edu.ufps.condominio.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class DashboardController {
	
	@GetMapping({"","/","index"})
	public String showInicio() {
		return "home";
	}
}
