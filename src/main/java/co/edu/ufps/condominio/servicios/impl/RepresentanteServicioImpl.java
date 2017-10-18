package co.edu.ufps.condominio.servicios.impl;

import java.util.Calendar;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import co.edu.ufps.condominio.entity.Persona;
import co.edu.ufps.condominio.entity.Representante;
import co.edu.ufps.condominio.entity.User;
import co.edu.ufps.condominio.entity.UserRole;
import co.edu.ufps.condominio.entity.Vivienda;
import co.edu.ufps.condominio.modelo.FormRepresentante;
import co.edu.ufps.condominio.repository.PersonaRepository;
import co.edu.ufps.condominio.repository.RepresentanteRepository;
import co.edu.ufps.condominio.repository.UserRepository;
import co.edu.ufps.condominio.repository.ViviendaRepository;
import co.edu.ufps.condominio.servicios.RepresentanteServicio;
import co.edu.ufps.condominio.util.Respuesta;

@Service("RepresentanteServicioImpl")
public class RepresentanteServicioImpl implements RepresentanteServicio {
	private Log log = LogFactory.getLog(Representante.class);
	@Autowired
	@Qualifier("RepresentanteRepository")
	private RepresentanteRepository representanteRepository;

	@Autowired
	@Qualifier("PersonaRepository")
	private PersonaRepository personaRepository;

	@Autowired
	@Qualifier("ViviendaRepository")
	private ViviendaRepository viviendaRepository;

	@Autowired
	@Qualifier("UserRepository")
	private UserRepository userRepository;

	@Override
	public Respuesta<String> registrar(FormRepresentante form) {
		Respuesta<String> message = new Respuesta<>();
		Vivienda vivienda = viviendaRepository.findById(form.getVivienda());
		if (vivienda.isHabitada()) {
			message.setEstado(false);
			message.setValor("Vivienda esta ocupada");
			return message;
		}
		vivienda.setHabitada(true);
		viviendaRepository.save(vivienda);

		// roles de usuario
		User user = userRepository.findByUsername(form.getNombreUsuario());
		// user no existe
		if (user == null) {
			Set<UserRole> roles = new HashSet<>();
			user = new User();
			user.setEnabled(true);
			user.setUsername(form.getNombreUsuario());
			BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
			String hashedPassword = passwordEncoder.encode(form.getPassword());
			user.setPassword(hashedPassword);
			roles.add(new UserRole(user, "representante"));
			user.setUserRole(roles);
		}
		// user ya existe
		else {
			user.setEnabled(true);
		}
		log.info("user: " + user.toString());
		userRepository.save(user);

		// registrar la persona
		Persona persona = personaRepository.findById(form.getNombreUsuario());
		if (persona == null) {
			persona = new Persona();
			persona.setDocumento(form.getNombreUsuario());
		}
		Representante representante = new Representante();
		representante.setFechaInicio(Calendar.getInstance());
		representante.setPersona(persona);
		representante.setVivienda(vivienda);
		if (representanteRepository.saveAndFlush(representante) != null) {
			message.setEstado(true);
			message.setValor("Registro exitoso");
		}
		return message;
	}

	@Override
	public List<Representante> listar() {
		return representanteRepository.findAll();
	}

	@Override
	public FormRepresentante buscar(int id) {
		Representante representante = representanteRepository.findById(id);
		FormRepresentante frm = new FormRepresentante();
		frm.setNombreUsuario(representante.getPersona().getDocumento());
		frm.setVivienda(representante.getVivienda().getId());
		if (representante.getFechaFinal() == null) {
			frm.setEstado(1);
		} else {
			frm.setEstado(0);
		}
		return frm;
	}

	@Override
	public Respuesta<String> desactivar(int id) {
		Respuesta<String> response = null;
		Representante representante = representanteRepository.findById(id);
		if (representante == null) {
			return response = new Respuesta<>(false, "no existe representante");
		}
		if (representante.getFechaFinal() != null) {
			return response = new Respuesta<>(false, "ya esta desactivado");
		}
		// liberar vivienda
		Vivienda vivienda = representante.getVivienda();
		vivienda.setHabitada(false);
		representante.setVivienda(vivienda);

		// agregar fecha Final
		representante.setFechaFinal(Calendar.getInstance());

		// save representante
		if (representanteRepository.save(representante) != null) {
			User user = userRepository.findByUsername(representante.getPersona().getDocumento());
			// comprueba que el USER no tenga asignada viviendas
			if (representanteRepository.findByPersonaAndFechaFinalIsNull(representante.getPersona()).isEmpty()) {
				user.setEnabled(false);
			}
			userRepository.saveAndFlush(user);
			response = new Respuesta<String>(true, "representante desactivado");
		}

		return response;
	}

}
