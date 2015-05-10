package br.com.while42.treinofitness.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public abstract class AbstractExercicio implements Exercicio {
	
	private @Id @GeneratedValue Long id;
	private String nome;
	private long series = MINIMO_SERIES;

	@ManyToOne(cascade=CascadeType.PERSIST)
	private Treino treino;
	
	@Deprecated
	public AbstractExercicio() {
	}
	
	public AbstractExercicio(String nome, long series) {
		this.nome = nome;
		this.series = series;
	}

	@Override
	public Long getId() {
		return id;
	}

	@Override
	public String getNome() {
		return nome;
	}
	
	@Override
	public final void setSeries(long series) {
		this.series = series;
	}
	
	@Override
	public final long getSeries() {
		return series;
	}
}
