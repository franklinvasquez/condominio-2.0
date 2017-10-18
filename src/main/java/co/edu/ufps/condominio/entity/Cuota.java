package co.edu.ufps.condominio.entity;

import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="cuota")
public class Cuota {
	
	@Id
	@GeneratedValue
	@Column(name="id_cuota",unique = true , nullable = false)
	private int id;
	
	@Column(name="descripcion", length=35, nullable = false)
	private String descripcion;
	
	@Column(name = "fecha_final", nullable = false)
	@Temporal(TemporalType.TIMESTAMP)
	private Calendar fechafinal;
	
	@Column(name = "fecha_inicio", nullable = false)
	@Temporal(TemporalType.TIMESTAMP)
	private Calendar fechaInicio;
	
	@Column(precision=8, scale=2, columnDefinition="decimal(10,2)") 
	private float valor;
	
	@OneToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="id_recibo", nullable=true)
	private Recibo recibo;
	
	public Cuota() {}

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

	public Calendar getFechafinal() {
		return fechafinal;
	}

	public void setFechafinal(Calendar fechafinal) {
		this.fechafinal = fechafinal;
	}

	public Calendar getFechaInicio() {
		return fechaInicio;
	}

	public void setFechaInicio(Calendar fechaInicio) {
		this.fechaInicio = fechaInicio;
	}

	public float getValor() {
		return valor;
	}

	public void setValor(float valor) {
		this.valor = valor;
	}

	public Recibo getRecibo() {
		return recibo;
	}

	public void setRecibo(Recibo recibo) {
		this.recibo = recibo;
	}
	
}
