package co.edu.ufps.condominio.entity;

import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="notificacion")
public class Notificacion {
	
	@Id
	@GeneratedValue
	@Column(name="id_notificacion",unique = true , nullable = false)
	private int id;
	
	@Column(name = "fecha_publicacion", nullable = false)
	@Temporal(TemporalType.TIMESTAMP)
	private Calendar fechaPublicacion;
	
	@Column(name = "fecha_evento", nullable = true)
	@Temporal(TemporalType.TIMESTAMP)
	private Calendar fechaEvento;
	
	@Column(name="informacion", columnDefinition = "TEXT", nullable = false)
	private String informacion;
	
	@Column(name="titulo", length=45, nullable = false)
	private String titulo;
	
	@Column(name="tipo_evento",length=1)
	private char tipo;
	

	
	public Notificacion() {}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Calendar getFechaPublicacion() {
		return fechaPublicacion;
	}

	public void setFechaPublicacion(Calendar fechaPublicacion) {
		this.fechaPublicacion = fechaPublicacion;
	}

	public Calendar getFechaEvento() {
		return fechaEvento;
	}

	public void setFechaEvento(Calendar fechaEvento) {
		this.fechaEvento = fechaEvento;
	}

	public String getInformacion() {
		return informacion;
	}

	public void setInformacion(String informacion) {
		this.informacion = informacion;
	}

	public char getTipo() {
		return tipo;
	}

	public void setTipo(char tipo) {
		this.tipo = tipo;
	}
	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String resumenInf() {
		if(informacion.length()<40)return informacion;
		return informacion.substring(0, 40);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Notificacion other = (Notificacion) obj;
		if (id != other.id)
			return false;
		return true;
	}
	
		
}
