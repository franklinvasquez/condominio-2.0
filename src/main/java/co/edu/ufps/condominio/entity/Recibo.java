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
@Table(name="recibo")
public class Recibo {
	
	@Id
	@GeneratedValue
	@Column(name="id_recibo",unique = true , nullable = false)
	private int id;
	
	@Column(name = "fecha_recibo", nullable = false)
	@Temporal(TemporalType.TIMESTAMP)
	private Calendar fecha;
	
	@Column(precision=8, scale=2, columnDefinition="decimal(10,2)") 
	private float valor;
	
	public Recibo() {}

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
	
	
}
