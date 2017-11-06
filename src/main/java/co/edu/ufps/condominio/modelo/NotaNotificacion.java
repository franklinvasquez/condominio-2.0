package co.edu.ufps.condominio.modelo;

import java.util.Calendar;

public class NotaNotificacion {
	private String titulo;
	private String mensaje;
	private Calendar fecha;
	private boolean estado;
	private int idVivienda;
	private String nombreVivienda;
	
	public NotaNotificacion(){}
	
	
	public boolean isEstado() {
		return estado;
	}

	public void setEstado(boolean estado) {
		this.estado = estado;
	}

	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getMensaje() {
		return mensaje;
	}
	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}
	public Calendar getFecha() {
		return fecha;
	}
	public void setFecha(Calendar fecha) {
		this.fecha = fecha;
	}
	public int getIdVivienda() {
		return idVivienda;
	}
	public void setIdVivienda(int idVivienda) {
		this.idVivienda = idVivienda;
	}
	public String getNombreVivienda() {
		return nombreVivienda;
	}
	public void setNombreVivienda(String nombreVivienda) {
		this.nombreVivienda = nombreVivienda;
	}
	
	
}
