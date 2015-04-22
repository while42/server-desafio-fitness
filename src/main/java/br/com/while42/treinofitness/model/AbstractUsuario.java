package br.com.while42.treinofitness.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public abstract class AbstractUsuario {

	private @Id @GeneratedValue Long id;
	
	private final String username;
	private @JsonIgnore String senha;
	
	@ManyToOne(cascade=CascadeType.ALL)
	private @JsonIgnore Academia academia;
	
	@Deprecated
	public AbstractUsuario() {
		username = null;
	}
	
	public AbstractUsuario(String username) {
		this.username = username;
	}
	
	public Long getId() {
		return id;
	}
	
	public String getUsername() {
		return username;
	}
	
	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public Academia getAcademia() {
		return academia;
	}
	
	public final void setAcademia(Academia academia) {
		this.academia = academia;
	}
	
	@Override
	public String toString() {
		return getUsername();
	}
}
