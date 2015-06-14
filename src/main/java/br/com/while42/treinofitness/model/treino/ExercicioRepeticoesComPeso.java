package br.com.while42.treinofitness.model.treino;

import javax.persistence.Entity;

@Entity
public class ExercicioRepeticoesComPeso extends AbstractExercicio {
	
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
	
	@SuppressWarnings("deprecation")
	public ExercicioRepeticoesComPeso(Treino treino){
		setTreino(treino);
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
	
	public String getString(){
		return getNome() + " - " + getRepeticoes() + " repetições com " + getPeso() + "kg";
	}
}
