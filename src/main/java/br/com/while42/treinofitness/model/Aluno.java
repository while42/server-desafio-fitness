package br.com.while42.treinofitness.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import br.com.while42.treinofitness.model.treino.Treino;

@Entity
public class Aluno extends Usuario {

	@ManyToOne(cascade=CascadeType.PERSIST)
	private Instrutor instrutor;

	@OneToMany(cascade=CascadeType.PERSIST)
	private List<Treino> treinos = new ArrayList<Treino>();
	
	@Deprecated
	public Aluno() {
		super("", "", TipoUsuario.ALUNO);
	}

	public Aluno(String login, String nome) {
		super(login, nome, TipoUsuario.ALUNO);
	}

	public Instrutor getInstrutor() {
		return instrutor;
	}

	public void setInstrutor(Instrutor instrutor) {
		this.instrutor = instrutor;
	}
	
	public void setAcademia(Academia academia){
		super.setAcademia(academia);
	}

	public void addTreino(Treino treino) {
		treinos.add(treino);
	}

	public List<Treino> getTreinos() {
		return treinos;
	}

	@Override
	public String toString() {
		return getUsername();
	}
	
	public boolean getHasInstrutor(){
		if(instrutor != null){
			return true;
		}
		return false;
	}
	public boolean getHasAcademia(){
		if(getAcademia() != null){
			return true;
		}
		return false;
	}

}
