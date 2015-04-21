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

	public Long getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

	public List<Instrutor> getInstrutores() {
		return instrutores;
	}

	final void addUsuario(AbstractUsuario usuario) {
		if (usuario instanceof Aluno) {
			addAluno((Aluno) usuario);
		} else if (usuario instanceof Instrutor) {
			addInstrutor((Instrutor) usuario);
		}
	}
	
	public final void addAluno(Aluno aluno) {
		alunos.add(aluno);
	}

	public final void addInstrutor(Instrutor instrutor) {
		instrutores.add(instrutor);
	}
	
	public List<Aluno> getAlunos() {
		return alunos;
	}

	
	@Override
	public String toString() {
		return getNome();
	}

}
