package co.edu.ufps.condominio.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="instalacion")
public class Instalacion {
	
	@Id
	@GeneratedValue
	@Column(name="id_instalacion",unique = true , nullable = false)
	private int id;
	
	@Column(name="descripcion", length=35, nullable = false)
	private String descripcion;
	
	@OneToMany(mappedBy="instalacion",fetch=FetchType.LAZY)
	private List<Reserva> reservas;
	
	public Instalacion() {}

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

	public List<Reserva> getReservas() {
		return reservas;
	}

	public void setReservas(List<Reserva> reservas) {
		this.reservas = reservas;
	}
	
	
}
