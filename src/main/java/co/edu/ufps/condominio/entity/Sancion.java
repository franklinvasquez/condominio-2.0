package co.edu.ufps.condominio.entity;

import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="sancion")
public class Sancion {
	
	@Id
	@GeneratedValue
	@Column(name="id_sancion",unique = true , nullable = false)
	private int id;
	
	@Column(name = "fecha_sancion", nullable = false)
	@Temporal(TemporalType.TIMESTAMP)
	private Calendar fecha;
	
	@Column(name="tipo_sancion", length=35, nullable = false)
	private String tipo;
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="id_vivienda")
	private Vivienda vivienda;
	
	@OneToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="id_recibo", nullable=true)
	private Recibo recibo;
	
	public Sancion() {
		
	}

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

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public Vivienda getVivienda() {
		return vivienda;
	}

	public void setVivienda(Vivienda vivienda) {
		this.vivienda = vivienda;
	}

	public Recibo getRecibo() {
		return recibo;
	}

	public void setRecibo(Recibo recibo) {
		this.recibo = recibo;
	}
	
	
}
