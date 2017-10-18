package co.edu.ufps.condominio.servicios.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import co.edu.ufps.condominio.entity.Persona;
import co.edu.ufps.condominio.entity.User;
import co.edu.ufps.condominio.modelo.formPerfil;
import co.edu.ufps.condominio.repository.PersonaRepository;
import co.edu.ufps.condominio.repository.UserRepository;
import co.edu.ufps.condominio.servicios.PersonaServicio;
import co.edu.ufps.condominio.util.Respuesta;

@Service("PersonaServicioImpl")
public class PersonaServicioImpl implements PersonaServicio {

	@Autowired
	@Qualifier("PersonaRepository")
	private PersonaRepository personaRepository;
	
	@Autowired
	@Qualifier("UserRepository")
	private UserRepository userRepository;
	
	@Override
	public Respuesta<String> registrar(Persona persona) {
		Respuesta<String> ret = new Respuesta<String>(false, "Error al registrar");
		boolean existe =personaRepository.existsById(persona.getDocumento());
		if(!existe) {
			personaRepository.saveAndFlush(persona);
			ret.setEstado(true);
			ret.setValor("Registro exitoso");
		}
		else {
			ret.setValor("Ya existe el documento");
		}
		
		return ret;
	}
	@Override
	public Respuesta<String> actualizar(formPerfil frm) {
		Respuesta<String> response=null;
		//actualizar contraseña
		if(!frm.getPassword().isEmpty()) {
			User user = userRepository.findByUsername(frm.getId());
			BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
			String hashedPassword = passwordEncoder.encode(frm.getPassword());
			user.setPassword(hashedPassword);
			userRepository.save(user);
		}
		Persona persona=personaRepository.findById(frm.getId());
		persona.setNombres(frm.getNombres());
		persona.setApellidos(frm.getApellidos());
		persona.setCorreo(frm.getCorreo());
		persona.setGenero((frm.getGenero() != 0));
		if(personaRepository.saveAndFlush(persona)!=null){
			response= new Respuesta<>(true,"Actualizacion exitosa");
		}
		return response;
	}
	@Override
	public Persona buscar(String id) {
		return personaRepository.findById(id);
	}

}
