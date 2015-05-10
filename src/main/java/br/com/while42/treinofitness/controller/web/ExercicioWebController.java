package br.com.while42.treinofitness.controller.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import br.com.while42.treinofitness.model.AbstractExercicio;
import br.com.while42.treinofitness.model.Aluno;
import br.com.while42.treinofitness.repository.AlunoRepository;
import br.com.while42.treinofitness.repository.ExercicioRepository;

@Controller
@RequestMapping("/exercicio")
public class ExercicioWebController {

	private @Autowired ExercicioRepository exercicioRepository;
	private @Autowired AlunoRepository alunoRepository;

	@RequestMapping(value = "/todos", method = RequestMethod.GET)
	public String all(Model model) {
		Iterable<AbstractExercicio> exercicios = exercicioRepository.findAll();

		model.addAttribute("exercicios", exercicios);

		return "exercicio-lista";
	}

	@RequestMapping(value = "/form", method = RequestMethod.GET)
	public String form(@RequestParam Long alunoId, Model model) {
		Aluno aluno = alunoRepository.findOne(alunoId);

		model.addAttribute("aluno", aluno);
		return "exercicio-form";
	}
	
	@RequestMapping(value = "/", method = RequestMethod.POST)
	public String save(@RequestParam Long alunoId, Model model) {
		Aluno aluno = alunoRepository.findOne(alunoId);

		model.addAttribute("aluno", aluno);
		return "exercicio-form";
	}
}
