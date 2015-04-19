package br.com.while42.treinofitness.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Transient;

@Entity
public class Instrutor extends Usuario {

	@Transient // TODO: <- Falta arrumar
	public final List<Aluno> alunos = new ArrayList<Aluno>();

	public Instrutor(String login) {
		super(login);
	}

	public List<Aluno> getAlunos() {
		return alunos;
	}

	public void addAluno(Aluno aluno) {
		aluno.setInstrutor(this);
		alunos.add(aluno);
	}

	@Override
	public String toString() {
		return getLogin();
	}
}
