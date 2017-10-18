package co.edu.ufps.condominio.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/seguridad")
public class LoginController {
	
	
	@GetMapping("/login")
	public String showLoginForm(Model model, 
			@RequestParam(name="error", required=false) String error,
			@RequestParam(name="logout",required=false) String logout) {
		
		model.addAttribute("error", error);
		model.addAttribute("logout", logout);
		
		return "login";
	}
	
}
