package br.com.while42.treinofitness.model;

import org.junit.Assert;
import org.junit.Test;

import br.com.while42.treinofitness.model.treino.ExercicioRepeticoesComPeso;
import br.com.while42.treinofitness.model.treino.Treino;
import br.com.while42.treinofitness.repository.AbstractExercicio;


public class TreinoTest {

	@Test
	public void testGetNome() {
		Treino treino = new Treino("treino" , "descricao");
		Assert.assertEquals("treino", treino.getNome());
	}

	@Test
	public void testGetDescicao() {
		Treino treino = new Treino("treino" , "descricao");
		Assert.assertEquals("descricao", treino.getDescricao());
	}
	
	@Test
	public void testConsistenciaTreinoExercicios() {
		Treino treino = new Treino("treino" , "descricao1");
		
		AbstractExercicio exercicio1 = new ExercicioRepeticoesComPeso("exercicio1", 3, 8);
		AbstractExercicio exercicio2 = new ExercicioRepeticoesComPeso("exercicio2", 4, 10);
		
		treino.addExercicio(exercicio1);
		treino.addExercicio(exercicio2);
		
		Assert.assertTrue(treino.getExercicios().contains(exercicio1));
		Assert.assertTrue(treino.getExercicios().contains(exercicio2));
	}
	
	@Test
	public void testToString() {
		Treino treino = new Treino("treino" , "descricao1");
		Assert.assertEquals("treino", treino.toString());
	}
}
