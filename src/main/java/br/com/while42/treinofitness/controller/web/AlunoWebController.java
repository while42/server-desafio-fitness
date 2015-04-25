package br.com.while42.treinofitness.controller.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import br.com.while42.treinofitness.model.Aluno;
import br.com.while42.treinofitness.repository.AlunoRepository;

@Controller
@RequestMapping("/aluno")
public class AlunoWebController {

	private @Autowired AlunoRepository alunoRepository;
	
	@RequestMapping(value = "/{alunoId}", method = RequestMethod.GET)
	public String get(@PathVariable String alunoId, Model model) {
		
		Aluno aluno = alunoRepository.findOne(Long.valueOf(alunoId));
		
		if (aluno != null) {
			model.addAttribute("id", aluno.getId());
			model.addAttribute("username", aluno.getUsername());
		}
		
		return "aluno";
	}

}
