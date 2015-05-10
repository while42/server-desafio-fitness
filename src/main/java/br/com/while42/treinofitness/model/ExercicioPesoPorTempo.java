package br.com.while42.treinofitness.model;

import javax.persistence.Entity;

@Entity
public class ExercicioPesoPorTempo extends AbstractExercicio {
	
	private double peso;
	private double tempoEmMinutos;

	@Deprecated
	public ExercicioPesoPorTempo() {
	}

	public ExercicioPesoPorTempo(String nome, double peso, double tempoEmMinutos) {
		this(nome, MINIMO_SERIES, peso, tempoEmMinutos);
	}
	
	public ExercicioPesoPorTempo(String nome, long series, double peso, double tempoEmMinutos) {
		super(nome, series);
		this.peso = peso;
		this.tempoEmMinutos = tempoEmMinutos;
	}

	public double getPeso() {
		return peso;
	}
	
	public void setPeso(double peso) {
		this.peso = peso;
	}
	
	public double getTempo() {
		return tempoEmMinutos;
	}
	
	public void setTempo(double minutos) {
		this.tempoEmMinutos = minutos;
	}
}
