package br.com.while42.treinofitness.controller.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import br.com.while42.treinofitness.model.Instrutor;
import br.com.while42.treinofitness.repository.InstrutorRepository;

@Controller
@RequestMapping("/instrutor")
public class InstrutorWebController {
	
	private @Autowired InstrutorRepository instrutorRepository;

	@RequestMapping(value = "/todos", method = RequestMethod.GET)
	public String all(Model model){
		Iterable<Instrutor> instrutores = instrutorRepository.findAll();
		
		model.addAttribute("instrutores", instrutores);
		
		return "instrutor-lista";
	} 
	
	
	@RequestMapping(value = "/{instrutorId}", method = RequestMethod.GET)
	public String instrutor(@PathVariable String instrutorId, Model model) {
		Instrutor instrutor = instrutorRepository.findOne(Long.valueOf(instrutorId));
		
		if (instrutor != null) {
			model.addAttribute("instrutor", instrutor);
			model.addAttribute("alunos", instrutor.getAlunos());
			return "instrutor";
		}
		
		return "instrutor-inexistente";
	}
	
	
	
	
	
	
}
