package br.com.while42.treinofitness.controller.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import br.com.while42.treinofitness.model.Academia;
import br.com.while42.treinofitness.model.Aluno;
import br.com.while42.treinofitness.model.Instrutor;
import br.com.while42.treinofitness.repository.AcademiaRepository;

@Controller
@RequestMapping("/academia")
public class AcademiaWebController {

	private @Autowired AcademiaRepository academiaRepository;
	
	@RequestMapping(value = "/todos", method = RequestMethod.GET)
	public String listaAcademias(Model model){
		Iterable<Academia> academias = academiaRepository.findAll();
		model.addAttribute("academias", academias);
		return "academia-lista";
	}
	
	@SuppressWarnings("deprecation")
	@RequestMapping(value = "/novo", method = RequestMethod.GET)
	public String formNovaAcademia(Model model) {
		model.addAttribute("academia", new Academia());
		return "academia-form";
	}
	
	@RequestMapping(value = "/{academiaId}/editar", method = RequestMethod.GET)
	public String formEditarAcademia(@PathVariable Long academiaId, Model model) {
		Academia academia = academiaRepository.findOne(Long.valueOf(academiaId));
		
		if (academia == null) {
			// TODO: Falta tratar o caso da acadmia nao existir mais
		}
		
		model.addAttribute("academia", academia);
		return "academia-form";
	}
	
	@RequestMapping(value = "/salvar", method = RequestMethod.POST)
	public String salvar(@ModelAttribute Academia academia) {
		academiaRepository.save(academia);
		return "redirect:/academia/todos";
	}
	
	@RequestMapping(value = "/{academiaId}", method = RequestMethod.GET)
	public String academia(@PathVariable Long academiaId, Model model) {
		Academia academia = academiaRepository.findOne(academiaId);
		
		model.addAttribute("academia", academia);
		return "academia";
	}
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String academiaDoLogin(Model model) {
		// TODO
		return "academia";
	}
	
	@RequestMapping(value = "/excluir", method = RequestMethod.POST)
	public String deletaAcademia(@RequestParam Long academiaId, Model model) {
		academiaRepository.delete(academiaId);
		return "redirect:/academia/todos";
	}
	
	@RequestMapping(value = "/{academiaId}/aluno/todos", method = RequestMethod.GET)
	public String alunosDaAcademia(@PathVariable Long academiaId, Model model) {
		
		List<Aluno> alunos = academiaRepository.findOne(academiaId).getAlunos();
		
		model.addAttribute("alunos", alunos);
		return "aluno-lista";
	}
	
	@RequestMapping(value = "/{academiaId}/instrutor/todos", method = RequestMethod.GET)
	public String instrutoresDaAcademia(@PathVariable Long academiaId, Model model) {
		
		List<Instrutor> instrutores = academiaRepository.findOne(academiaId).getInstrutores();
		
		model.addAttribute("instrutores", instrutores);
		return "instrutor-lista";
	}
}