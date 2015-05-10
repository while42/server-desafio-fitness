package br.com.while42.treinofitness.controller.web;

import lombok.extern.log4j.Log4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import br.com.while42.treinofitness.model.Aluno;
import br.com.while42.treinofitness.model.Treino;
import br.com.while42.treinofitness.repository.AlunoRepository;
import br.com.while42.treinofitness.repository.TreinoRepository;

@Log4j
@Controller
@RequestMapping("/treino")
public class TreinoWebController {

	private @Autowired TreinoRepository treinoRepository;
	private @Autowired AlunoRepository alunoRepository;

	@RequestMapping(value = "/todos", method = RequestMethod.GET)
	public String all(Model model) {
		Iterable<Treino> treinos = treinoRepository.findAll();

		model.addAttribute("treinos", treinos);

		return "treino-lista";
	}

	@RequestMapping(value = "/form", method = RequestMethod.GET)
	public String form(@RequestParam long alunoId, Model model) {
		Aluno aluno = alunoRepository.findOne(alunoId);

		model.addAttribute("aluno", aluno);
		model.addAttribute("treino", new Treino("", ""));
		log.debug("foi para a pagina do form");

		return "treino-form";
	}

	@RequestMapping(value = "/", method = RequestMethod.POST)
	public String save(@ModelAttribute Treino treino, @RequestParam Long alunoId) {

		Aluno aluno = alunoRepository.findOne(alunoId);
		aluno.addTreino(treino);
		log.debug("Aluno ja tem exercicio");
		alunoRepository.save(aluno);
		log.debug("Aluno salvo no repositorio");

		return "redirect:/treino/todos";
	}
}
