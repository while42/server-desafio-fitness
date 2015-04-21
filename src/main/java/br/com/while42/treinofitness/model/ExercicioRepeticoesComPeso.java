package br.com.while42.treinofitness.model;

import javax.persistence.Entity;

@Entity
public class ExercicioRepeticoesComPeso extends Exercicio {
	
	private long repeticoes;
	private double peso;

	@Deprecated
	public ExercicioRepeticoesComPeso() {
	}
	
	public ExercicioRepeticoesComPeso(String nome, long repeticoes, double peso) {
		this(nome, MINIMO_SERIES, repeticoes, peso);
	}

	public ExercicioRepeticoesComPeso(String nome, long series, long repeticoes, double peso) {
		super(nome, series);
		this.repeticoes = repeticoes;
		this.peso = peso;
	}

	public long getRepeticoes() {
		return repeticoes;
	}
	
	public void setRepeticoes(long repeticoes) {
		this.repeticoes = repeticoes;
	}
	
	public double getPeso() {
		return peso;
	}
	
	public void setPeso(double peso) {
		this.peso = peso;
	}
}
