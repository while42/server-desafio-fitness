package br.com.while42.treinofitness.controller.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.while42.treinofitness.model.Academia;
import br.com.while42.treinofitness.model.Aluno;
import br.com.while42.treinofitness.model.Instrutor;
import br.com.while42.treinofitness.repository.AcademiaRepository;

@RestController
@RequestMapping(ApiControllerConfiguration.BASE_URL_API + "/academia")
public class AcademiaController {
	
	private @Autowired AcademiaRepository academiaRepository;

	@RequestMapping(value = "/todos", method = RequestMethod.GET)
	public ResponseEntity<Iterable<Academia>> lista(){
		return new ResponseEntity<Iterable<Academia>>(academiaRepository.findAll(), HttpStatus.OK);
	}
	
	@RequestMapping(value = "/{academiaId}", method = RequestMethod.GET)
	public ResponseEntity<Academia> get(@PathVariable String academiaId) {
		return new ResponseEntity<Academia>(academiaRepository.findOne(Long.valueOf(academiaId)), HttpStatus.OK);
	}
	
	@RequestMapping(value = "/{academiaId}", method = RequestMethod.DELETE)
	public ResponseEntity<?> delete(@PathVariable String academiaId) {
		academiaRepository.delete(Long.valueOf(academiaId));
		return new ResponseEntity<>(null, HttpStatus.OK);
	}

	@RequestMapping(method = {RequestMethod.POST, RequestMethod.PUT})
	public ResponseEntity<?> save(@RequestBody Academia academia) {
		if (academia == null) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		
		HttpStatus httpStatus = (academia.getId() == null) ? HttpStatus.CREATED : HttpStatus.OK;
		
		academia = academiaRepository.save(academia);
		return new ResponseEntity<Academia>(academia, httpStatus);
	}
	
	@RequestMapping(value = "/{academiaId}/aluno/todos", method = RequestMethod.GET)
	public ResponseEntity<List<Aluno>> alunos(@PathVariable String academiaId) {
		return new ResponseEntity<List<Aluno>>(academiaRepository.findOne(Long.valueOf(academiaId)).getAlunos(), HttpStatus.OK);
	}
	
	@RequestMapping(value = "/{academiaId}/instrutor/todos", method = RequestMethod.GET)
	public ResponseEntity<List<Instrutor>> instrutores(@PathVariable String academiaId) {
		return new ResponseEntity<List<Instrutor>>(academiaRepository.findOne(Long.valueOf(academiaId)).getInstrutores(), HttpStatus.OK);
	}
}
