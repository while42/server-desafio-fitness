package br.com.while42.treinofitness.model;

import org.junit.Assert;
import org.junit.Test;

import br.com.while42.model.Academia;
import br.com.while42.model.Aluno;
import br.com.while42.model.Instrutor;

public class AcademiaTest {

	
	@Test
	public void testGetNome() {
		Academia academia = new Academia("Academia de Teste");
		Assert.assertEquals("Academia de Teste", academia.getNome());
	}
	
	@Test
	public void testConsistenciaAcademiaInstrutor() {
		Academia academia = new Academia("Academia de Teste");
		Instrutor instrutor = new Instrutor("instrutor");

		academia.addInstrutor(instrutor);
		
		Assert.assertTrue(academia.getInstrutores().contains(instrutor));
		Assert.assertTrue(instrutor.getAcademia().equals(academia));
	}
	
	@Test
	public void testConsistenciaAcademiaAlunos() {
		Academia academia = new Academia("Academia de Teste");
		
		Aluno aluno1 = new Aluno("aluno1");
		Aluno aluno2 = new Aluno("aluno2");
		
		academia.addAluno(aluno1);
		academia.addAluno(aluno2);
		
		Assert.assertTrue(academia.getAlunos().contains(aluno1));
		Assert.assertTrue(academia.getAlunos().contains(aluno2));
		
		Assert.assertTrue(aluno1.getAcademia().equals(academia));
		Assert.assertTrue(aluno2.getAcademia().equals(academia));
	}
	
	@Test
	public void testToString() {
		Academia academia = new Academia("Academia de Teste");
		Assert.assertEquals("Academia de Teste", academia.toString());
	}

}
