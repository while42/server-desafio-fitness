package br.com.while42.treinofitness.model;

import org.junit.Assert;
import org.junit.Test;

import br.com.while42.treinofitness.model.Aluno;
import br.com.while42.treinofitness.model.treino.Treino;

public class AlunoTest {

	@Test
	public void testConsistenciaAlunoTreinos() {
		Treino treino1 = new Treino("treino1" , "descricao1");
		Treino treino2 = new Treino("treino2" , "descricao2");
		
		Aluno aluno = new Aluno("aluno", "aluno-nome");
		aluno.addTreino(treino1);
		aluno.addTreino(treino2);
		
		Assert.assertTrue(aluno.getTreinos().contains(treino1));
		Assert.assertTrue(aluno.getTreinos().contains(treino2));
	}
	
	@Test
	public void testToString() {
		Aluno aluno1 = new Aluno("aluno1", "aluno-nome");
		Assert.assertEquals("aluno1", aluno1.toString());
	}

}
