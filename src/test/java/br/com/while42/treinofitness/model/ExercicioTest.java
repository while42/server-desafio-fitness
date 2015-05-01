package br.com.while42.treinofitness.model;

import org.junit.Assert;
import org.junit.Test;

public class ExercicioTest {

	@Test
	public void testGetNome() {
		Exercicio exercicio = new ExercicioRepeticoesComPeso("exercicio", 10, 11);
		Assert.assertEquals("exercicio", exercicio.getNome());
	}

	@Test
	public void testToString() {
		Exercicio exercicio = new ExercicioRepeticoesComPeso("exercicio", 10, 11);
		Assert.assertEquals(Exercicio.MINIMO_SERIES + "x exercicio", exercicio.toString());
	}

}
