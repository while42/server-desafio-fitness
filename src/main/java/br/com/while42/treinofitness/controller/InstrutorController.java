package br.com.while42.treinofitness.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.while42.treinofitness.model.Instrutor;
import br.com.while42.treinofitness.repository.InstrutorRepository;

@RestController
@RequestMapping("/instrutor")
public class InstrutorController {
	
	private @Autowired InstrutorRepository instrutorRepository;

	@RequestMapping(value = "/todos", method = RequestMethod.GET)
	public Iterable<Instrutor> lista(){
		return instrutorRepository.findAll();
	}

}
