package br.com.while42.treinofitness.model;

public interface Exercicio {

	public static final long MINIMO_SERIES = 1;

	public abstract Long getId();

	public abstract String getNome();

	public abstract void setSeries(long series);

	public abstract long getSeries();
}