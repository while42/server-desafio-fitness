package br.com.while42.treinofitness.controller.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.while42.treinofitness.repository.AbstractExercicio;
import br.com.while42.treinofitness.repository.ExercicioRepository;

@RestController
@RequestMapping(ApiControllerConfiguration.BASE_URL_API + "/exercicio")
public class ExercicioController {
	private @Autowired ExercicioRepository exercicioRepository;
	
	@RequestMapping(value = "/todos", method = RequestMethod.GET)
	public Iterable<AbstractExercicio> lista() {
		return exercicioRepository.findAll();
	}

	@RequestMapping(value = "/{exercicioId}", method = RequestMethod.GET)
	public ResponseEntity<AbstractExercicio> exercicio(@PathVariable String exercicioId) {
		return new ResponseEntity<AbstractExercicio>(exercicioRepository.findOne(Long.valueOf(exercicioId)), HttpStatus.OK);
	}

	@RequestMapping(value = "/{exercicioId}", method = RequestMethod.DELETE)
	public ResponseEntity<?> delete(@PathVariable String exercicioId) {
		exercicioRepository.delete(Long.valueOf(exercicioId));
		return new ResponseEntity<>(null, HttpStatus.OK);
	}

	@RequestMapping(value = "/", method = {RequestMethod.POST, RequestMethod.PUT})
	public ResponseEntity<?> save(@RequestBody AbstractExercicio exercicio) {
		if (exercicio == null) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		
		HttpStatus httpStatus = (exercicio.getId() == null) ? HttpStatus.CREATED : HttpStatus.OK;
	
		exercicioRepository.save(exercicio);
		return new ResponseEntity<AbstractExercicio>(exercicio, httpStatus);
	}
}
