package br.com.while42.treinofitness.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Transient;

@Entity
public abstract class Usuario {

	private @Id @GeneratedValue Long id;
	
	private final String login;
	
	@Transient // TODO: <- Falta arrumar
	private Academia academia;
	
	public Usuario(String login) {
		this.login = login;
	}
	
	public String getLogin() {
		return login;
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
