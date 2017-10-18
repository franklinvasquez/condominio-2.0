package co.edu.ufps.condominio.entity;

import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="habita")
public class Habita {
	
	@EmbeddedId
	private HabitaPK id;
	
	@Column(name = "fecha_fin", nullable = true)
	@Temporal(TemporalType.TIMESTAMP)
	private Calendar fechaFin;

	public HabitaPK getId() {
		return id;
	}

	public void setId(HabitaPK id) {
		this.id = id;
	}

	public Calendar getFechaFin() {
		return fechaFin;
	}

	public void setFechaFin(Calendar fechaFin) {
		this.fechaFin = fechaFin;
	}
	
	
}
