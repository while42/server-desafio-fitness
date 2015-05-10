package br.com.while42.treinofitness.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Usuario {

	private @Id @GeneratedValue Long id;
	
	private String username;
	private String nome;
	private @JsonIgnore String senha;
	
	@ManyToOne(cascade=CascadeType.ALL)
	private @JsonIgnore Academia academia;
	
	@Deprecated
	Usuario() {
		username = null;
	}
	
	public Usuario(String username, String nome) {
		this.username = username;
		this.nome = nome;
	}
	
	public Long getId() {
		return id;
	}
	
	public void setUsername(String username) {
		this.username = username;
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

	public void removeSenha() {
		this.senha = null;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getNome() {
		return nome;
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
