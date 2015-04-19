package br.com.while42.model;

import java.util.ArrayList;
import java.util.List;

public final class Academia implements Cloneable {

	private Long id;
	private final String nome;

	private final List<Instrutor> instrutores = new ArrayList<Instrutor>();
	private final List<Aluno> alunos = new ArrayList<Aluno>();

	public Academia(String nome) {
		this.nome = nome;
	}

	public String getNome() {
		return nome;
	}

	public void addInstrutor(Instrutor instrutor) {
		instrutor.setAcademia(this);
		instrutores.add(instrutor);
	}

	public List<Instrutor> getInstrutores() {
		return instrutores;
	}

	public void addAluno(Aluno aluno) {
		aluno.setAcademia(this);
		alunos.add(aluno);
	}

	public List<Aluno> getAlunos() {
		return alunos;
	}

	
	@Override
	public String toString() {
		return getNome();
	}
}
