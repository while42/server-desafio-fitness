package br.com.while42.treinofitness.controller.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.while42.treinofitness.model.Treino;
import br.com.while42.treinofitness.repository.TreinoRepository;

@RestController
@RequestMapping(ApiControllerConfiguration.BASE_URL_API + "/treino")
public class TreinoController {

	private @Autowired TreinoRepository treinoRepository;
	
	@RequestMapping(value = "/todos", method = RequestMethod.GET)
	public Iterable<Treino> lista() {
		return treinoRepository.findAll();
	}
	
	@RequestMapping(value = "/{treinoId}", method = RequestMethod.GET)
	public ResponseEntity<Treino> treino(@PathVariable String treinoId) {
		return new ResponseEntity<Treino>(treinoRepository.findOne(Long.valueOf(treinoId)), HttpStatus.OK);
	}
	
	// TODO: Created method to return treinos by userId 

	@RequestMapping(value = "/{treinoId}", method = RequestMethod.DELETE)
	public ResponseEntity<?> delete(@PathVariable String treinoId) {
		treinoRepository.delete(Long.valueOf(treinoId));
		return new ResponseEntity<>(null, HttpStatus.OK);
	}

	@RequestMapping(value = "/", method = {RequestMethod.POST, RequestMethod.PUT})
	public ResponseEntity<?> save(@RequestBody Treino treino) {
		if (treino == null) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		
		HttpStatus httpStatus = (treino.getId() == null) ? HttpStatus.CREATED : HttpStatus.OK;

		treinoRepository.save(treino);
		return new ResponseEntity<Treino>(treino, httpStatus);
	}
}

