package co.edu.ufps.condominio.entity;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="destinatario_notificacion")
public class DestinatarioNotificacion {
	
	@EmbeddedId
	private DestinatarioNotificacionPK id;
	
	@Column(name="lectura", columnDefinition="tinyint(1) default 0")
	private boolean lectura;

	public DestinatarioNotificacion() {}
	
	public DestinatarioNotificacion(DestinatarioNotificacionPK id, boolean lectura) {
		super();
		this.id = id;
		this.lectura = lectura;
	}

	public DestinatarioNotificacionPK getId() {
		return id;
	}

	public void setId(DestinatarioNotificacionPK id) {
		this.id = id;
	}

	public boolean isLectura() {
		return lectura;
	}

	public void setLectura(boolean lectura) {
		this.lectura = lectura;
	}
	
	

}
