package br.com.while42.treinofitness.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Academia implements Cloneable {

	private @Id @GeneratedValue Long id;
	private final String nome;

	@OneToMany
	private @JsonIgnore final List<Instrutor> instrutores = new ArrayList<Instrutor>();
	
	@OneToMany
	private @JsonIgnore final List<Aluno> alunos = new ArrayList<Aluno>();

	@Deprecated
	public Academia() {
		nome = null;
	}
	
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
