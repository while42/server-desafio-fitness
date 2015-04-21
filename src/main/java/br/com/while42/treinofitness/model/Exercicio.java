package br.com.while42.treinofitness.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public abstract class Exercicio {
	
	private @Id @GeneratedValue Long id;
	private String nome;

	@ManyToOne(cascade=CascadeType.PERSIST)
	private Treino treino;
	
	@Deprecated
	public Exercicio() {
	}
	
	public Exercicio(String nome) {
		this.nome = nome;
	}

	public Long getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}
	
	@Override
	public String toString() {
		return nome;
	}
}
