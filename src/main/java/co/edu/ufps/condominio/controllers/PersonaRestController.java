package co.edu.ufps.condominio.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/restpersona")
public class PersonaRestController {
		
	
	@GetMapping("/saludar")
	public ResponseEntity<String>saludar(){
		return new ResponseEntity<String>("Hola mundo", HttpStatus.OK);
	}
	
	@GetMapping("habla")
	public ResponseEntity<String>hola(@RequestParam(name="saludo") String nombre){
		return new ResponseEntity<>(nombre, HttpStatus.ACCEPTED);
	}
	
}

