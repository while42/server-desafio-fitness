package br.com.while42.treinofitness.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Aluno extends Usuario {

	@ManyToOne(cascade=CascadeType.ALL)
	private Instrutor instrutor;

	@OneToMany
	private List<Treino> treinos = new ArrayList<Treino>();

	@Deprecated
	public Aluno() {
		
	}

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
