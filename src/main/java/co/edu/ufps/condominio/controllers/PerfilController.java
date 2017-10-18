package co.edu.ufps.condominio.controllers;

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

import co.edu.ufps.condominio.entity.Persona;
import co.edu.ufps.condominio.modelo.formPerfil;
import co.edu.ufps.condominio.servicios.PersonaServicio;
import co.edu.ufps.condominio.util.Respuesta;

@Controller
@RequestMapping("/perfil")
public class PerfilController {
	
	@Autowired
	@Qualifier("PersonaServicioImpl")
	private PersonaServicio personaServivicio;
	private Log log = LogFactory.getLog(PerfilController.class);
	
	@GetMapping({"","/"})
	public String showInicio(Model model) {
		User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	    String name = user.getUsername(); //get logged in username
	    Persona persona=personaServivicio.buscar(name);
		model.addAttribute("persona", persona);
		return "perfil";
	}
	
	@PostMapping("/registrar")
	public @ResponseBody Respuesta<String> actualizar(@ModelAttribute @Valid formPerfil frm, BindingResult result) {
		User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	    frm.setId(user.getUsername());
	    
		Respuesta<String>response = null;
		if(!result.hasErrors()) {
			response=personaServivicio.actualizar(frm);
		}
		else {
			response = new Respuesta<String>(false, "error en el formulario");
			response.calcularMap(result.getFieldErrors());
		}
		return response;
	}
}
