package co.edu.ufps.condominio.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import co.edu.ufps.condominio.modelo.FormRepresentante;
import co.edu.ufps.condominio.servicios.RepresentanteServicio;
import co.edu.ufps.condominio.servicios.ViviendaServicio;
import co.edu.ufps.condominio.util.Respuesta;

@Controller
@RequestMapping("/representante")
public class RepresentanteController {
	private final static String  VIEW_PRINCIPAL="cuentasUsuarios";
	
	@Autowired
	@Qualifier("ViviendaServicioImpl")
	private ViviendaServicio viviendaServicio;
	
	@Autowired
	@Qualifier("RepresentanteServicioImpl")
	private RepresentanteServicio representanteServicio;
	
	@GetMapping("/cuentas")
	public String showCuentas(Model model) {
		model.addAttribute("viviendas", viviendaServicio.listadoByEstado(false));
		model.addAttribute("representantes", representanteServicio.listar());
		return VIEW_PRINCIPAL;
		
	}
	@GetMapping("/refreshTable")
	public  String refreshTableRepresentante(Model model) {
		model.addAttribute("representantes", representanteServicio.listar());
		return VIEW_PRINCIPAL+"::models_table";
	}
	@GetMapping("/refreshSelect")
	public String refreshSelect(Model model) {
		model.addAttribute("viviendas", viviendaServicio.listadoByEstado(false));
		return VIEW_PRINCIPAL+"::models_select";
	}
	@PostMapping("/registrar")
	public @ResponseBody Respuesta<String> registrar(@ModelAttribute @Valid FormRepresentante form, BindingResult result){
		Respuesta<String>response = new Respuesta<String>();
		if(!result.hasErrors()) {
			response=representanteServicio.registrar(form);
		}
		else {
			response.setEstado(false);
			response.setValor("error en el formulario");
			response.calcularMap(result.getFieldErrors());
		}
		
		return response;
	}
	
	@PostMapping("/desactivar")
	public @ResponseBody Respuesta<String>desactivar(@RequestParam(name="id") int id){
		return representanteServicio.desactivar(id);
	}
		
}
