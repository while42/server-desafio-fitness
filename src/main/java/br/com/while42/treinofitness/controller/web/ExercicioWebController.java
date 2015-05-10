package br.com.while42.treinofitness.controller.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import br.com.while42.treinofitness.model.AbstractExercicio;
import br.com.while42.treinofitness.model.Aluno;
import br.com.while42.treinofitness.model.ExercicioDistanciaPorTempo;
import br.com.while42.treinofitness.model.ExercicioPesoPorTempo;
import br.com.while42.treinofitness.model.ExercicioRepeticoes;
import br.com.while42.treinofitness.model.ExercicioRepeticoesComPeso;
import br.com.while42.treinofitness.model.ExercicioTempo;
import br.com.while42.treinofitness.model.Treino;
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
	public String form(@RequestParam Long alunoId, @RequestParam Long treinoId,
			Model model) {
		Aluno aluno = alunoRepository.findOne(alunoId);

		Treino treinoQueVaiReceberUmExercicio = null;

		for (Treino treino : aluno.getTreinos()) {
			if (treino.getId().equals(treinoId)) {
				treinoQueVaiReceberUmExercicio = treino;
			}
		}

		model.addAttribute("aluno", aluno);
		model.addAttribute("treino", treinoQueVaiReceberUmExercicio);
		model.addAttribute("exercicioDistanciaPorTempo" , new ExercicioDistanciaPorTempo("", 0, 0));
		model.addAttribute("exercicioPesoPorTempo" , new ExercicioPesoPorTempo("", 0, 0));
		model.addAttribute("exercicioRepeticoes" , new ExercicioRepeticoes("", 0, 0));
		model.addAttribute("exercicioRepeticoesComPeso" , new ExercicioRepeticoesComPeso("", 0, 0));
		model.addAttribute("exercicioTempo" , new ExercicioTempo("", 0, 0));
		return "exercicio-form";
	}

	@RequestMapping(value = "/exercicioTempo", method = RequestMethod.POST)
	public String save(@ModelAttribute ExercicioTempo exercicioTempo, 
					   @RequestParam Long alunoId, @RequestParam Long treinoId, Model model) {
		
		return "exercicio-form";
	}
}
