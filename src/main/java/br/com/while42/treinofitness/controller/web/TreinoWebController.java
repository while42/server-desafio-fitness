package br.com.while42.treinofitness.controller.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import br.com.while42.treinofitness.model.Treino;
import br.com.while42.treinofitness.repository.TreinoRepository;

@Controller
@RequestMapping("/treino")
public class TreinoWebController {

	private @Autowired TreinoRepository treinoRepository;
	private @Autowired TreinoRepository academiaRepository;
	
	@RequestMapping(value = "/todos", method = RequestMethod.GET)
	public String all(Model model){
		Iterable<Treino> academias = academiaRepository.findAll();
		
		model.addAttribute("treinos", academias);
		
		return "treino-lista";
	} 
}
