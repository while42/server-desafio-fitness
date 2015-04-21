package br.com.while42.treinofitness.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.while42.treinofitness.model.Aluno;
import br.com.while42.treinofitness.repository.AlunoRepository;

@RestController
@RequestMapping("/aluno")
public class AlunoController {
	
	private @Autowired AlunoRepository alunoRepository;

	@RequestMapping(value = "/todos", method = RequestMethod.GET)
	public Iterable<Aluno> lista(){
		return alunoRepository.findAll();
	}

}
