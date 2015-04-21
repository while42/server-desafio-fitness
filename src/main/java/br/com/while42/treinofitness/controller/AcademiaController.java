package br.com.while42.treinofitness.controller;

import org.springframework.beans.factory.annotation.Autowired;
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
	public Iterable<Academia> lista(){
		return academiaRepository.findAll();
	}
	
	@RequestMapping(value = "/{academiaId}", method = RequestMethod.GET)
	public Academia academia(@PathVariable String academiaId) {
		return academiaRepository.findOne(Long.valueOf(academiaId));
	}
}
