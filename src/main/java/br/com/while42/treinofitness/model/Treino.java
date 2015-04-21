package br.com.while42.treinofitness.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Treino {

	private @Id @GeneratedValue Long id;
	
	private String nome;
	private String descricao;
	
	@OneToMany
	private final List<Exercicio> exercicios = new ArrayList<Exercicio>();
	
	@ManyToOne(cascade=CascadeType.PERSIST)
	private Aluno aluno;

	@Deprecated
	public Treino() {
	}
	
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
