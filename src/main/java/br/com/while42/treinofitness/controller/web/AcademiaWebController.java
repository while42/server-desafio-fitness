package br.com.while42.treinofitness.controller.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import br.com.while42.treinofitness.model.Aluno;
import br.com.while42.treinofitness.repository.AcademiaRepository;

@Controller
@RequestMapping("/academia")
public class AcademiaWebController {

	private @Autowired AcademiaRepository academiaRepository;
	
	@RequestMapping(value = "/{academiaId}/aluno/todos", method = RequestMethod.GET)
	public String get(@PathVariable String academiaId, Model model) {
		
		List<Aluno> alunos = academiaRepository.findOne(Long.valueOf(academiaId)).getAlunos();
		
		model.addAttribute("alunos", alunos);
		
		return "aluno-lista";
	}

}
