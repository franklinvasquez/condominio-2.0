package co.edu.ufps.condominio.modelo;


import java.io.Serializable;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
public class FormRepresentante implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	// message = "First name is required"
	@NotNull
	@Size(min=6, max=15)
	private String nombreUsuario;
	//@NotNull
	//@Size(min=8, max=30)
	private String password;
	
	private String repeatPassword;
	@NotNull
	private int vivienda;
	@NotNull
	private int estado;
	
	public FormRepresentante() {
		
	}
	
	public FormRepresentante(String nombreUsuario, String password, String repeatPassword, int vivienda,
			int estado) {
		super();
		this.nombreUsuario = nombreUsuario;
		this.password = password;
		this.repeatPassword = repeatPassword;
		this.vivienda = vivienda;
		this.estado = estado;
	}
	public String getNombreUsuario() {
		return nombreUsuario;
	}
	public void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getRepeatPassword() {
		return repeatPassword;
	}
	public void setRepeatPassword(String repeatPassword) {
		this.repeatPassword = repeatPassword;
	}
	public int getVivienda() {
		return vivienda;
	}
	public void setVivienda(int vivienda) {
		this.vivienda = vivienda;
	}
	public int getEstado() {
		return estado;
	}
	public void setEstado(int estado) {
		this.estado = estado;
	}
	
	
}
