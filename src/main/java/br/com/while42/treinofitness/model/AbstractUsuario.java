package br.com.while42.treinofitness.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class AbstractUsuario {

	private @Id @GeneratedValue Long id;
	
	private String username = "";
	private String nome = "";
	private TipoUsuario tipo;
	private @JsonIgnore String senha;
	
	private @JsonIgnore boolean deletado = false;
		
	public boolean isDeletado() {
		return deletado;
	}

	public void setDeletado(boolean deletado) {
		this.deletado = deletado; 
	}

	@Deprecated
	AbstractUsuario() {
	}
	
	public AbstractUsuario(String username, String nome, TipoUsuario tipo) {
		this.username = username;
		this.nome = nome;
		this.tipo = tipo;
	}
	
	public Long getId() {
		return id;
	}
	
	@Deprecated
	public void setId(Long id){
		this.id = id;
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
	
	public TipoUsuario getTipoUsuario() {
		return tipo;
	}
	
	@Override
	public String toString() {
		return getUsername();
	}

}
