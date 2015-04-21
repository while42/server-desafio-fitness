package br.com.while42.treinofitness.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.while42.treinofitness.model.Exercicio;
import br.com.while42.treinofitness.repository.ExercicioRepository;

@RestController
@RequestMapping("/exercicio")
public class ExercicioController {
	private @Autowired ExercicioRepository exercicioRepository;
	
	@RequestMapping(value = "/todos", method = RequestMethod.GET)
	public Iterable<Exercicio> lista() {
		return exercicioRepository.findAll();
	}
	
	@RequestMapping(value = "/{exercicioId}", method = RequestMethod.GET)
	public Exercicio exercicio(@PathVariable String exercicioId) {
		return exercicioRepository.findOne(Long.valueOf(exercicioId));
	}
}
