package br.com.while42.treinofitness.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public abstract class Usuario {

	private @Id @GeneratedValue Long id;
	
	private final String login;
	private @JsonIgnore String senha;
	
	@Transient // TODO: <- Falta arrumar
	private @JsonIgnore Academia academia;
	
	public Usuario(String login) {
		this.login = login;
	}
	
	public String getLogin() {
		return login;
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
	
	public void setAcademia(Academia academia) {
		this.academia = academia;
	}
	
	@Override
	public String toString() {
		return getLogin();
	}
}
