package br.com.while42.treinofitness.model;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;

public class AcademiaTest {

	@Test
	public void testGetNome() {
		Academia academia = new Academia("Academia de Teste");
		Assert.assertEquals("Academia de Teste", academia.getNome());
	}

	@Test
	public void testConsistenciaAcademiaInstrutor() {
		Academia academia = new Academia("Academia de Teste");
		Instrutor instrutor = new Instrutor("instrutor", "instrutor-nome");

		instrutor.setAcademia(academia);
		academia.addInstrutor(instrutor);

		List<Instrutor> instrutores = academia.getInstrutores();
		
		Assert.assertTrue(instrutores.contains(instrutor));
		Assert.assertTrue(instrutor.getAcademia().equals(academia));
	}

	@Test
	public void testConsistenciaAcademiaAlunos() {
		Academia academia = new Academia("Academia de Teste");

		Aluno aluno1 = new Aluno("aluno1", "aluno-nome");
		Aluno aluno2 = new Aluno("aluno2", "aluno-nome");

		academia.addAluno(aluno1);
		aluno1.setAcademia(academia);
		
		academia.addAluno(aluno2);
		aluno2.setAcademia(academia);

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
