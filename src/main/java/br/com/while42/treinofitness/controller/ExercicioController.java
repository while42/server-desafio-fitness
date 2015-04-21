package br.com.while42.treinofitness.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
	public ResponseEntity<Exercicio> get(@PathVariable String exercicioId) {
		return new ResponseEntity<Exercicio>(exercicioRepository.findOne(Long.valueOf(exercicioId)), HttpStatus.OK);
	}

	@RequestMapping(value = "/{exercicioId}", method = RequestMethod.DELETE)
	public ResponseEntity<?> delete(@PathVariable String exercicioId) {
		exercicioRepository.delete(Long.valueOf(exercicioId));
		return new ResponseEntity<>(null, HttpStatus.OK);
	}

	@RequestMapping(value = "/{exercicioId}", method = RequestMethod.POST)
	public ResponseEntity<?> save(Exercicio exercicio) {
		HttpStatus httpStatus = HttpStatus.OK;
		if (exercicio.getId() == null) {
			httpStatus = HttpStatus.CREATED;
		}

		exercicioRepository.save(exercicio);
		return new ResponseEntity<>(null, httpStatus);
	}
}
