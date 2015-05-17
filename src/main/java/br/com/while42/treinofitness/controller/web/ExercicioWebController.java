package br.com.while42.treinofitness.controller.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import br.com.while42.treinofitness.model.AbstractExercicio;
import br.com.while42.treinofitness.model.ExercicioDistanciaPorTempo;
import br.com.while42.treinofitness.model.ExercicioPesoPorTempo;
import br.com.while42.treinofitness.model.ExercicioRepeticoes;
import br.com.while42.treinofitness.model.ExercicioRepeticoesComPeso;
import br.com.while42.treinofitness.model.ExercicioTempo;
import br.com.while42.treinofitness.model.Treino;
import br.com.while42.treinofitness.repository.AlunoRepository;
import br.com.while42.treinofitness.repository.ExercicioRepository;
import br.com.while42.treinofitness.repository.TreinoRepository;

@Controller
@RequestMapping("/exercicio")
public class ExercicioWebController {

	private @Autowired ExercicioRepository exercicioRepository;
	private @Autowired AlunoRepository alunoRepository;
	private @Autowired TreinoRepository treinoRepository;

	@RequestMapping(value = "/todos", method = RequestMethod.GET)
	public String all(Model model) {
		Iterable<AbstractExercicio> exercicios = exercicioRepository.findAll();

		model.addAttribute("exercicios", exercicios);

		return "exercicio-lista";
	}

	@RequestMapping(value = "/form", method = RequestMethod.GET)
	public String form(@RequestParam Long treinoId,
			Model model) {

		Treino treinoQueVaiReceberUmExercicio = treinoRepository.findOne(treinoId);
		
		model.addAttribute("aluno", treinoQueVaiReceberUmExercicio.getAluno());
		model.addAttribute("treino", treinoQueVaiReceberUmExercicio);
		model.addAttribute("exercicioDistanciaPorTempo" , new ExercicioDistanciaPorTempo("", 0, 0));
		model.addAttribute("exercicioPesoPorTempo" , new ExercicioPesoPorTempo("", 0, 0));
		model.addAttribute("exercicioRepeticoes" , new ExercicioRepeticoes("", 0, 0));
		model.addAttribute("exercicioRepeticoesComPeso" , new ExercicioRepeticoesComPeso("", 0, 0));
		model.addAttribute("exercicioTempo" , new ExercicioTempo(treinoQueVaiReceberUmExercicio));
		return "exercicio-form";
	}
	
	
	@RequestMapping(value = "/excluir", method = RequestMethod.POST)
	public String exclui(@RequestParam Long treinoId){
		treinoRepository.delete(treinoId);
		return "redirect:exercicio/todos";
		
	}
}
