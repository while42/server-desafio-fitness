package br.com.while42.treinofitness.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public abstract class Exercicio {
	
	public static final long MINIMO_SERIES = 1;
	
	private @Id @GeneratedValue Long id;
	private String nome;
	private long series = MINIMO_SERIES;

	@ManyToOne(cascade=CascadeType.PERSIST)
	private Treino treino;
	
	@Deprecated
	public Exercicio() {
	}
	
	public Exercicio(String nome, long series) {
		this.nome = nome;
		this.series = series;
	}

	public Long getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}
	
	public final void setSeries(long series) {
		this.series = series;
	}
	
	public final long getSeries() {
		return series;
	}
	
	@Override
	public String toString() {
		return series + "x " + nome;
	}
}
