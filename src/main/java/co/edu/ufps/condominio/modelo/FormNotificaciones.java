package co.edu.ufps.condominio.modelo;


import java.util.Calendar;
import java.util.Map;

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
	private Map<Integer, String> viviendas;
	
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

	
}
