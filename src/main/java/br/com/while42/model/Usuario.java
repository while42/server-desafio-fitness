package br.com.while42.model;

public abstract class Usuario {

	private Long id;
	private final String login;
	
	public Usuario(String login) {
		this.login = login;
	}
	
	public String getLogin() {
		return login;
	}
}
