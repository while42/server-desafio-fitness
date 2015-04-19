package br.com.while42.treinofitness.model;

import org.junit.Assert;
import org.junit.Test;

import br.com.while42.treinofitness.model.Academia;
import br.com.while42.treinofitness.model.Aluno;
import br.com.while42.treinofitness.model.Instrutor;

public class InstrutorTest {

	@Test
	public void testGetAcademia() {
		Academia academia = new Academia("Academia de Teste");
		Instrutor instrutor = new Instrutor("instrutor");

		academia.addInstrutor(instrutor);
		Assert.assertTrue(instrutor.getAcademia().equals(academia));
	}

	@Test
	public void testConsistenciaInstrutorAlunos() {
		Instrutor instrutor = new Instrutor("instrutor");
		
		Aluno aluno1 = new Aluno("aluno1");
		Aluno aluno2 = new Aluno("aluno2");

		instrutor.addAluno(aluno1);
		instrutor.addAluno(aluno2);
		
		Assert.assertTrue(instrutor.getAlunos().contains(aluno1));
		Assert.assertTrue(instrutor.getAlunos().contains(aluno2));
		
		Assert.assertTrue(aluno1.getInstrutor().equals(instrutor));
		Assert.assertTrue(aluno2.getInstrutor().equals(instrutor));
	}

	@Test
	public void testToString() {
		Instrutor instrutor = new Instrutor("instrutor");
		Assert.assertEquals("instrutor", instrutor.toString());
	}
}
