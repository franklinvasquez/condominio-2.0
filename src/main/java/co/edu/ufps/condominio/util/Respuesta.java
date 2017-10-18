package co.edu.ufps.condominio.util;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.validation.FieldError;

public class Respuesta<T> {
	
	private  boolean estado;
	private  T valor;
	private Map<String, String> errorMessages;
	
	public Respuesta(boolean estado, T valor) {
		super();
		this.estado = estado;
		this.valor = valor;
		this.errorMessages = new HashMap<>();
	}
	public Respuesta() {
		this.errorMessages = new HashMap<>();
	}

	public boolean isEstado() {
		return estado;
	}

	public T getValor() {
		return valor;
	}

	public void setEstado(boolean estado) {
		this.estado = estado;
	}

	public void setValor(T valor) {
		this.valor = valor;
	}

	public Map<String, String> getErrorMessages() {
		return errorMessages;
	}

	public void setErrorMessages(Map<String, String> errorMessages) {
		this.errorMessages = errorMessages;
	}
	
	public void calcularMap(List<FieldError> errores) {
		for(FieldError error:errores) {
			errorMessages.put(error.getField(), error.getDefaultMessage());
		}
	}
	
	
	
}
