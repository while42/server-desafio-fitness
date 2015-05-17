package br.com.while42.treinofitness.model;

import javax.persistence.Entity;

@Entity
public class ExercicioCustomizado extends AbstractExercicio {
	

	@Deprecated
	public ExercicioCustomizado() {
	}
	
	public ExercicioCustomizado(String nome, String descricao) {
		super(nome, MINIMO_SERIES);
		setDescricao(descricao);
	}

	public String getString(){
		return getNome() + " - " + getDescricao();
	}
}
