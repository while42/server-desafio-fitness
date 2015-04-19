package br.com.while42.treinofitness.model;

import java.util.ArrayList;
import java.util.List;

public class Treino {

	private String nome;
	private String descricao;
	
	private final List<Exercicio> exercicios = new ArrayList<Exercicio>();

	public Treino(String nome, String descricao) {
		this.nome = nome;
		this.descricao = descricao;
	}

	public String getNome() {
		return nome;
	}

	public String getDescricao() {
		return descricao;
	}
	
	public void addExercicio(Exercicio exercicio) {
		exercicios.add(exercicio);
	}

	public List<Exercicio> getExercicios() {
		return exercicios;
	}
	
	@Override
	public String toString() {
		return nome;
	}
}
