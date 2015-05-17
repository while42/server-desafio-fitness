package br.com.while42.treinofitness.model;

import javax.persistence.Entity;

@Entity
public class Administrador extends Usuario {

	@Deprecated
	public Administrador() {
	}

	public Administrador(String login, String nome) {
		super(login, nome);
	}

	@Override
	public String toString() {
		return getUsername();
	}
}
