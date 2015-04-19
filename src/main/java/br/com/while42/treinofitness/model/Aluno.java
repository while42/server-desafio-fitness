package br.com.while42.treinofitness.model;

import java.util.ArrayList;
import java.util.List;

public class Aluno extends Usuario {
	
	private Instrutor instrutor;
	private List<Treino> treinos = new ArrayList<Treino>();

	public Aluno(String login) {
		super(login);
	}

	public Instrutor getInstrutor() {
		return instrutor;
	}

	public void setInstrutor(Instrutor instrutor) {
		this.instrutor = instrutor;
	}
	
	public void addTreino(Treino treino) {
		treinos.add(treino);
	}
	
	public List<Treino> getTreinos() {
		return treinos;
	}
	
	@Override
	public String toString() {
		return getLogin();
	}
}
