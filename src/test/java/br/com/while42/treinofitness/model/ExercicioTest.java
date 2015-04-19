package br.com.while42.treinofitness.model;

import org.junit.Assert;
import org.junit.Test;

import br.com.while42.model.Exercicio;

public class ExercicioTest {

	@Test
	public void testGetNome() {
		Exercicio exercicio = new Exercicio("exercicio");
		Assert.assertEquals("exercicio", exercicio.getNome());
	}

	@Test
	public void testToString() {
		Exercicio exercicio = new Exercicio("exercicio");
		Assert.assertEquals("exercicio", exercicio.toString());
	}

}
