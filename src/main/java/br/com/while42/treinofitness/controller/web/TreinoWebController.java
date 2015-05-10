package br.com.while42.treinofitness.controller.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import br.com.while42.treinofitness.model.Aluno;
import br.com.while42.treinofitness.model.Treino;
import br.com.while42.treinofitness.repository.AlunoRepository;
import br.com.while42.treinofitness.repository.TreinoRepository;

@Controller
@RequestMapping("/treino")
public class TreinoWebController {

	private @Autowired TreinoRepository treinoRepository;
	private @Autowired AlunoRepository AlunoRepository;
	
	@RequestMapping(value = "/todos", method = RequestMethod.GET)
	public String all(Model model){
		Iterable<Treino> academias = treinoRepository.findAll();
		
		model.addAttribute("treinos", academias);
		
		return "treino-lista";
	} 
	
	@RequestMapping(value = "/form", method = RequestMethod.GET)
	public String form(@RequestParam long alunoId, Model model){
		Aluno aluno = AlunoRepository.findOne(alunoId);
		
		model.addAttribute("aluno", aluno);
		
		return "treino-form";
	} 
}
