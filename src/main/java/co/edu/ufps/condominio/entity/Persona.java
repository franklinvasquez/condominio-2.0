package co.edu.ufps.condominio.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="persona")
public class Persona {

	@Id
	@Column(name="documento",length=15, unique = true , nullable = false)
	private String id;
	
	//@NotNull
	@Column(name="nombres",length=35, nullable = true)
	private String nombres;
	
	//@NotNull
	@Column(name="apellidos",length=35, nullable = true)
	private String apellidos;
	
	//@Email
	@Column(name="correo",length=45, nullable = true, unique=true)
	private String correo;
	
	//@NotNull
	@Column(name="genero", columnDefinition="tinyint(1) default 0")
	private boolean genero;

	public Persona(String documento, String nombres, String apellidos, String correo, boolean genero) {
		super();
		this.id = documento;
		this.nombres = nombres;
		this.apellidos = apellidos;
		this.correo = correo;
		this.genero = genero;
	}
	
	public Persona() {}

	public String getDocumento() {
		return id;
	}

	public void setDocumento(String documento) {
		this.id = documento;
	}

	public String getNombres() {
		return nombres;
	}

	public void setNombres(String nombres) {
		this.nombres = nombres;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public boolean isGenero() {
		return genero;
	}

	public void setGenero(boolean genero) {
		this.genero = genero;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
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
		Persona other = (Persona) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return id;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	
	
}
