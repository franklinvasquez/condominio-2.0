package co.edu.ufps.condominio.modelo;


import java.util.Calendar;
import java.util.Set;

import javax.validation.constraints.NotNull;

public class FormNotificaciones {
	@NotNull
	private String titulo;
	private String cuerpo;
	@NotNull
	private Calendar fechaEvento;
	public String getTitulo() {
		return titulo;
	}
	public Set<Integer> viviendas;
	
	public FormNotificaciones() {
		
	}
	
	public FormNotificaciones(String titulo, String cuerpo, Calendar fechaEvento) {
		super();
		this.titulo = titulo;
		this.cuerpo = cuerpo;
		this.fechaEvento = fechaEvento;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getCuerpo() {
		return cuerpo;
	}
	public void setCuerpo(String cuerpo) {
		this.cuerpo = cuerpo;
	}
	public Calendar getFechaEvento() {
		return fechaEvento;
	}
	public void setFechaEvento(Calendar fechaEvento) {
		this.fechaEvento = fechaEvento;
	}
	public Set<Integer> getViviendas() {
		return viviendas;
	}

	public void setViviendas(Set<Integer> viviendas) {
		this.viviendas = viviendas;
	}
	
}
