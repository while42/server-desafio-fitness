package br.com.while42.treinofitness.controller.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.while42.treinofitness.model.Aluno;
import br.com.while42.treinofitness.repository.AlunoRepository;

@RestController
@RequestMapping(ApiControllerConfiguration.BASE_URL_API + "/aluno")
public class AlunoController {
	
	private @Autowired AlunoRepository alunoRepository;

	@RequestMapping(value = "/todos", method = RequestMethod.GET)
	public ResponseEntity<Iterable<Aluno>> all(){
		return new ResponseEntity<Iterable<Aluno>>(alunoRepository.findAll(), HttpStatus.OK);
	} 
	
	@RequestMapping(value = "/{alunoId}", method = RequestMethod.GET)
	public ResponseEntity<Aluno> get(@PathVariable String alunoId) {
		return new ResponseEntity<Aluno>(alunoRepository.findOne(Long.valueOf(alunoId)), HttpStatus.OK);
	}
	
	@RequestMapping(value = "/{alunoId}", method = RequestMethod.DELETE)
	public ResponseEntity<?> delete(@PathVariable String alunoId) {
		alunoRepository.delete(Long.valueOf(alunoId));
		return new ResponseEntity<>(null, HttpStatus.OK);
	}

	@RequestMapping(value = "/", method = {RequestMethod.POST, RequestMethod.PUT})
	public ResponseEntity<?> save(@RequestBody Aluno aluno) {
		if (aluno == null) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		
		HttpStatus httpStatus = (aluno.getId() == null) ? HttpStatus.CREATED : HttpStatus.OK;
		
		aluno = alunoRepository.save(aluno);
		return new ResponseEntity<Aluno>(aluno, httpStatus);
	}
}
