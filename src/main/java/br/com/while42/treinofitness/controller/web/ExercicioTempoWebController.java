package br.com.while42.treinofitness.controller.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import br.com.while42.treinofitness.model.ExercicioTempo;
import br.com.while42.treinofitness.model.Treino;
import br.com.while42.treinofitness.repository.AlunoRepository;
import br.com.while42.treinofitness.repository.ExercicioRepository;
import br.com.while42.treinofitness.repository.TreinoRepository;

@Controller
@RequestMapping("/exercicioTempo")
public class ExercicioTempoWebController {

	private @Autowired ExercicioRepository exercicioRepository;
	private @Autowired AlunoRepository alunoRepository;
	private @Autowired TreinoRepository treinoRepository;

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String save(@ModelAttribute ExercicioTempo exercicioTempo) {

		Treino treino = treinoRepository.findOne(exercicioTempo.getTreino()
				.getId());
		treino.addExercicio(exercicioTempo);
		exercicioTempo.setTreino(treino);
		exercicioRepository.save(exercicioTempo);

		return "redirect:/aluno/todos";
	}

}
