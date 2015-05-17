package br.com.while42.treinofitness.model.treino;

import javax.persistence.Entity;

import br.com.while42.treinofitness.repository.AbstractExercicio;

@Entity
public class ExercicioCustomizado extends AbstractExercicio {
	

	@Deprecated
	public ExercicioCustomizado() {
	}
	
	public ExercicioCustomizado(String nome, String descricao) {
		super(nome, MINIMO_SERIES);
		setDescricao(descricao);
	}

	@SuppressWarnings("deprecation")
	public ExercicioCustomizado(Treino treino){
		setTreino(treino);
	}
	
	public String getString(){
		return getNome() + " - " + getDescricao();
	}
}
