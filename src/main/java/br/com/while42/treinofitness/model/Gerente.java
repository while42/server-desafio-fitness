package br.com.while42.treinofitness.model;

import javax.persistence.Entity;

@Entity
public class Gerente extends AbstractUsuario {

	@Deprecated
	public Gerente() {
	}

	public Gerente(String login, String nome) {
		super(login, nome, TipoUsuario.GERENTE);
	}

	@Override
	public String toString() {
		return getUsername();
	}
}
