package br.com.while42.treinofitness.model;

import javax.persistence.Entity;

@Entity
public class ExercicioDistanciaPorTempo extends AbstractExercicio{
	
	private double distanciaEmMetros;
	private double tempoEmMinutos;

	@Deprecated
	public ExercicioDistanciaPorTempo() {
	}

	public ExercicioDistanciaPorTempo(String nome, double distanciaEmMetros, double tempoEmMinutos) {
		this(nome, MINIMO_SERIES, distanciaEmMetros, tempoEmMinutos);
	}
	
	public ExercicioDistanciaPorTempo(String nome, long series, double distanciaEmMetros, double tempoEmMinutos) {
		super(nome, series);
		this.distanciaEmMetros = distanciaEmMetros;
		this.tempoEmMinutos = tempoEmMinutos;
	}
	
	@SuppressWarnings("deprecation")
	public ExercicioDistanciaPorTempo(Treino treino){
		setTreino(treino);
	}

	public double getDistancia() {
		return distanciaEmMetros;
	}
	
	public void setDistancia(double metros) {
		this.distanciaEmMetros = metros;
	}
	
	public double getTempo() {
		return tempoEmMinutos;
	}
	
	public void setTempo(double minutos) {
		this.tempoEmMinutos = minutos;
	}
	
	public String getString(){
		return getNome() + " - " + getDistancia() + "m";
	}
}
