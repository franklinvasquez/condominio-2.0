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
@Table(name="reserva")
public class Reserva {

	@Id
	@GeneratedValue
	@Column(name="id_reserva",unique = true , nullable = false)
	private int id;
	
	@Column(name = "fecha_reserva", nullable = false)
	@Temporal(TemporalType.TIMESTAMP)
	private Calendar fecha;
	
	@Column(precision=8, scale=2, columnDefinition="decimal") 
	private float valor;
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="id_instalacion",nullable=false)
	private Instalacion instalacion;
	
	public Reserva() {}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Calendar getFecha() {
		return fecha;
	}

	public void setFecha(Calendar fecha) {
		this.fecha = fecha;
	}

	public float getValor() {
		return valor;
	}

	public void setValor(float valor) {
		this.valor = valor;
	}

	public Instalacion getInstalacion() {
		return instalacion;
	}

	public void setInstalacion(Instalacion instalacion) {
		this.instalacion = instalacion;
	}
	
	
}
