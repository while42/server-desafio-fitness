package br.com.while42.treinofitness.model.login;

public class Login {
	private String username;
	private String senha;
	
	public String getUsername() {
		return username;
	}
	
	public String getSenha() {
		return senha;
	}
	
	public void removeSenha() {
		this.senha = null;
	}
	
	public void setUsername(String username) {
		this.username = username;
	}
	
	public void setSenha(String senha) {
		this.senha = senha;
	}
}
