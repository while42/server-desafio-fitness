package br.com.while42.treinofitness.model;

import javax.persistence.Entity;

@Entity
public class ExercicioRepeticoesComPeso extends Exercicio {
	
	private int repeticoes;
	private double peso;

	@Deprecated
	public ExercicioRepeticoesComPeso() {
	}

	public ExercicioRepeticoesComPeso(String nome, int repeticoes, double peso) {
		super(nome);
		this.repeticoes = repeticoes;
		this.peso = peso;
	}

	public int getRepeticoes() {
		return repeticoes;
	}
	
	public void setRepeticoes(int repeticoes) {
		this.repeticoes = repeticoes;
	}
	
	public double getPeso() {
		return peso;
	}
	
	public void setPeso(double peso) {
		this.peso = peso;
	}
}
