package br.com.while42.treinofitness.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.while42.treinofitness.model.Academia;
import br.com.while42.treinofitness.repository.AcademiaRepository;

@RestController
@RequestMapping("/academia")
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

	@RequestMapping(value = "/", method = {RequestMethod.POST, RequestMethod.PUT})
	public ResponseEntity<?> save(Academia academia) {
		HttpStatus httpStatus = HttpStatus.OK;
		if (academia.getId() == null) {
			httpStatus = HttpStatus.CREATED;
		}
		
		academiaRepository.save(academia);
		return new ResponseEntity<>(null, httpStatus);
	}
	
}
