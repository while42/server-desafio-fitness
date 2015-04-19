package br.com.while42.model;

import java.util.ArrayList;
import java.util.List;

public class Instrutor extends Usuario {

	public final List<Aluno> alunos = new ArrayList<Aluno>();
	public Academia academia;
	
	public Instrutor(String login) {
		super(login);
	}

	public List<Aluno> getAlunos() {
		return alunos;
	}

	public Academia getAcademia() {
		return academia;
	}
	
	public void setAcademia(Academia academia) {
		this.academia = academia;
	}
	
	public void addAluno(Aluno aluno) {
		aluno.setInstrutor(this);
		alunos.add(aluno);
	}
}
