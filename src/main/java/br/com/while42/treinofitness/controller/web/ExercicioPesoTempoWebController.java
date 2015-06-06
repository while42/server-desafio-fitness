package br.com.while42.treinofitness.controller.web;

import lombok.extern.log4j.Log4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import br.com.while42.treinofitness.model.treino.ExercicioPesoPorTempo;
import br.com.while42.treinofitness.model.treino.Treino;
import br.com.while42.treinofitness.repository.AlunoRepository;
import br.com.while42.treinofitness.repository.ExercicioRepository;
import br.com.while42.treinofitness.repository.TreinoRepository;

@Log4j
@Controller
@RequestMapping("/exercicioPesoPorTempo")
public class ExercicioPesoTempoWebController {
	private @Autowired ExercicioRepository exercicioRepository;
	private @Autowired AlunoRepository alunoRepository;
	private @Autowired TreinoRepository treinoRepository;

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String save(@ModelAttribute ExercicioPesoPorTempo exercicioPesoTempo) {
		Long idAluno = 1l; //exercicioPesoTempo.getTreino().getAluno().getId();
		
		log.debug("Peso por tempo - Treino:" + exercicioPesoTempo.getTreino().getId() + " Aluno:" + idAluno);
		Treino treino = treinoRepository.findOne(exercicioPesoTempo.getTreino().getId());
		
		treino.addExercicio(exercicioPesoTempo);
		exercicioPesoTempo.setTreino(treino);
		exercicioRepository.save(exercicioPesoTempo);

		return "redirect:/aluno/todos";
	}
}
