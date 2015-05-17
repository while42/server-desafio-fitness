package br.com.while42.treinofitness.controller.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import br.com.while42.treinofitness.model.treino.ExercicioRepeticoes;
import br.com.while42.treinofitness.model.treino.Treino;
import br.com.while42.treinofitness.repository.AlunoRepository;
import br.com.while42.treinofitness.repository.ExercicioRepository;
import br.com.while42.treinofitness.repository.TreinoRepository;

@Controller
@RequestMapping("/exercicioRepeticoes")
public class ExercicioRepeticoesWebController {

	private @Autowired ExercicioRepository exercicioRepository;
	private @Autowired AlunoRepository alunoRepository;
	private @Autowired TreinoRepository treinoRepository;

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String save(@ModelAttribute ExercicioRepeticoes exercicioRepeticoes) {

		Treino treino = treinoRepository.findOne(exercicioRepeticoes.getTreino()
				.getId());
		treino.addExercicio(exercicioRepeticoes);
		exercicioRepeticoes.setTreino(treino);
		exercicioRepository.save(exercicioRepeticoes);

		return "redirect:/aluno/todos";
	}
}