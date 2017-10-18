package co.edu.ufps.condominio.entity;

import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="reclamo")
public class Reclamo {
	
	@Id
	@GeneratedValue
	@Column(name="id_reclamo",unique = true , nullable = false)
	private int id;
	
	@Column(name="descripcion", length=225, nullable = false)
	private String descripcion;
	
	@Column(name = "fecha_reclamo", nullable = false)
	@Temporal(TemporalType.TIMESTAMP)
	private Calendar fecha;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="id_vivienda")
	private Vivienda vivienda;
	
	public Reclamo() {}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Calendar getFecha() {
		return fecha;
	}

	public void setFecha(Calendar fecha) {
		this.fecha = fecha;
	}
	
	

}
