package co.edu.ufps.condominio.entity;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Embeddable
public class DestinatarioNotificacionPK implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "id_vivienda", referencedColumnName = "id_vivienda", nullable = false)
	private Vivienda vivienda;
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="id_notificacion", referencedColumnName = "id_notificacion", nullable = false)
	private Notificacion notificacion;

	public DestinatarioNotificacionPK() {
		
	}
	
	public DestinatarioNotificacionPK(Vivienda vivienda, Notificacion notificacion) {
		super();
		this.vivienda = vivienda;
		this.notificacion = notificacion;
	}

	public Vivienda getVivienda() {
		return vivienda;
	}

	public void setVivienda(Vivienda vivienda) {
		this.vivienda = vivienda;
	}

	public Notificacion getNotificacion() {
		return notificacion;
	}

	public void setNotificacion(Notificacion notificacion) {
		this.notificacion = notificacion;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((notificacion == null) ? 0 : notificacion.hashCode());
		result = prime * result + ((vivienda == null) ? 0 : vivienda.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof DestinatarioNotificacionPK))
			return false;
		DestinatarioNotificacionPK other = (DestinatarioNotificacionPK) obj;
		if (notificacion == null) {
			if (other.notificacion != null)
				return false;
		} else if (!notificacion.equals(other.notificacion))
			return false;
		if (vivienda == null) {
			if (other.vivienda != null)
				return false;
		} else if (!vivienda.equals(other.vivienda))
			return false;
		return true;
	}
	
	
	
}
