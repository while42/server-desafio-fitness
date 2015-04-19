package br.com.while42.treinofitness.model;

public abstract class Usuario {

	private Long id;
	private final String login;
	public Academia academia;
	
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
