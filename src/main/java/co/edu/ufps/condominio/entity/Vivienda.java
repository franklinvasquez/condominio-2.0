package co.edu.ufps.condominio.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="vivienda")
public class Vivienda {
	
	@Id
	@GeneratedValue
	@Column(name="id_vivienda",unique = true , nullable = false)
	private int id;
	
	@Column(name="numero", length=35, nullable = false, unique=true)
	private String numero;
	
	@Column(name="bloque", length=10, nullable = false)
	private String bloque;
	
	@Column(name="habitada", columnDefinition="tinyint(1) default 0")
	private boolean habitada;
	
	@OneToMany(fetch=FetchType.LAZY, cascade = CascadeType.ALL, mappedBy="vivienda")
	private List<Notificacion> notificaciones;
	
	@OneToMany(fetch=FetchType.LAZY,cascade=CascadeType.ALL, mappedBy="vivienda")
	private List<Reclamo> reclamos;
	
	@OneToMany(fetch=FetchType.LAZY,cascade=CascadeType.ALL,mappedBy="vivienda")
	private List<Sancion> sanciones;
	
	public Vivienda() {
		
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getBloque() {
		return bloque;
	}

	public void setBloque(String bloque) {
		this.bloque = bloque;
	}

	public boolean isHabitada() {
		return habitada;
	}

	public void setHabitada(boolean habitada) {
		this.habitada = habitada;
	}

	public List<Notificacion> getNotificaciones() {
		return notificaciones;
	}

	public void setNotificaciones(List<Notificacion> notificaciones) {
		this.notificaciones = notificaciones;
	}

	public List<Reclamo> getReclamos() {
		return reclamos;
	}

	public void setReclamos(List<Reclamo> reclamos) {
		this.reclamos = reclamos;
	}

	public List<Sancion> getSanciones() {
		return sanciones;
	}

	public void setSanciones(List<Sancion> sanciones) {
		this.sanciones = sanciones;
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
		Vivienda other = (Vivienda) obj;
		if (id != other.id)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return bloque+" - "+numero;
	}
	
	
	
}
