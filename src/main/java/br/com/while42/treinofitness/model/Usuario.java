package br.com.while42.treinofitness.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Usuario extends AbstractUsuario {

	@ManyToOne(cascade=CascadeType.ALL)
	private @JsonIgnore Academia academia;
	
	@Deprecated
	Usuario() {
	}
	
	public Usuario(String username, String nome, TipoUsuario tipo) {
		super(username, nome, tipo);
	}
	
	public Academia getAcademia() {
		return academia;
	}
	
	public void setAcademia(Academia academia) {
		this.academia = academia;
	}
	
	@Override
	public String toString() {
		return getUsername();
	}

}
