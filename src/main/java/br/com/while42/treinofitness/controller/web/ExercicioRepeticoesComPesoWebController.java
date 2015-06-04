package br.com.while42.treinofitness.controller.web;

import lombok.extern.log4j.Log4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import br.com.while42.treinofitness.model.treino.ExercicioRepeticoesComPeso;
import br.com.while42.treinofitness.model.treino.Treino;
import br.com.while42.treinofitness.repository.AlunoRepository;
import br.com.while42.treinofitness.repository.ExercicioRepository;
import br.com.while42.treinofitness.repository.TreinoRepository;

@Log4j
@Controller
@RequestMapping("/exercicioRepeticoesComPeso")
public class ExercicioRepeticoesComPesoWebController {
	private @Autowired ExercicioRepository exercicioRepository;
	private @Autowired AlunoRepository alunoRepository;
	private @Autowired TreinoRepository treinoRepository;

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String save(@ModelAttribute ExercicioRepeticoesComPeso exercicioRepeticoesPeso) {
		
		log.debug("Peso por tempo - Treino:" + exercicioRepeticoesPeso.getTreino().getId() );
		Treino treino = treinoRepository.findOne(exercicioRepeticoesPeso.getTreino().getId());
		
		treino.addExercicio(exercicioRepeticoesPeso);
		exercicioRepeticoesPeso.setTreino(treino);
		exercicioRepository.save(exercicioRepeticoesPeso);

		return "redirect:/aluno/todos";
	}
}
