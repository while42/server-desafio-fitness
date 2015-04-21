package br.com.while42.treinofitness.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.while42.treinofitness.model.Treino;
import br.com.while42.treinofitness.repository.TreinoRepository;

@RestController
@RequestMapping("/treino")
public class TreinoController {

	private @Autowired TreinoRepository treinoRepository;
	
	@RequestMapping(value = "/todos", method = RequestMethod.GET)
	public Iterable<Treino> lista() {
		return treinoRepository.findAll();
	}
	
	@RequestMapping(value = "/{treinoId}", method = RequestMethod.GET)
	public Treino treino(@PathVariable String treinoId) {
		return treinoRepository.findOne(Long.valueOf(treinoId));
	}
	
	// TODO: Created method to return treinos by userId 
	
}

