package br.com.while42.treinofitness.model.treino;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import br.com.while42.treinofitness.model.Aluno;
import br.com.while42.treinofitness.repository.AbstractExercicio;

@Entity
public class Treino {

	private @Id @GeneratedValue Long id;
	
	private String nome;
	private String descricao;
	
	@OneToMany(cascade=CascadeType.PERSIST)
	private final List<AbstractExercicio> exercicios = new ArrayList<AbstractExercicio>();
	
	@ManyToOne(cascade=CascadeType.PERSIST)
	private Aluno aluno;

	@Deprecated
	public Treino() {
	}
	
	public Treino(String nome, String descricao) {
		this.nome = nome;
		this.descricao = descricao;
	}
	
	public Treino(Aluno aluno) {
		this.aluno = aluno;
	}

	public Long getId(){
		return id;
	}
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome){
		this.nome = nome;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public void setDescricao(String desc){
		this.descricao = desc;
	}

	public String getDescricao() {
		return descricao;
	}
	
	public void addExercicio(AbstractExercicio exercicio) {
		exercicios.add(exercicio);
	}

	public List<AbstractExercicio> getExercicios() {
		return exercicios;
	}
	
	@Override
	public String toString() {
		return nome;
	}
	
	public void setAluno(Aluno aluno){
		this.aluno = aluno;
	}

	public Aluno getAluno() {
		return aluno;
	}
}
