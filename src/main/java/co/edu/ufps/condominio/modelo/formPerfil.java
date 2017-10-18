package co.edu.ufps.condominio.modelo;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Email;

public class formPerfil {
	private String id;
	@NotNull
	private String nombres;
	@NotNull
	private String apellidos;
	private String password;
	private String repeatPassword;
	@Email
	private String correo;
	@NotNull
	private int genero;
	
	public formPerfil() {}
	
	public formPerfil(String id, String nombres, String apellidos, String password, String repeatPassword,
			String correo, int genero) {
		super();
		this.id = id;
		this.nombres = nombres;
		this.apellidos = apellidos;
		this.password = password;
		this.repeatPassword = repeatPassword;
		this.correo = correo;
		this.genero = genero;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
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
	public String getCorreo() {
		return correo;
	}
	public void setCorreo(String correo) {
		this.correo = correo;
	}
	public int getGenero() {
		return genero;
	}
	public void setGenero(int genero) {
		this.genero = genero;
	}
	
	
}
