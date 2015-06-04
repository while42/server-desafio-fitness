package br.com.while42.treinofitness.controller.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import br.com.while42.treinofitness.model.Academia;
import br.com.while42.treinofitness.model.Aluno;
import br.com.while42.treinofitness.model.Instrutor;
import br.com.while42.treinofitness.repository.AcademiaRepository;

@Controller
@RequestMapping("/academia")
public class AcademiaWebController {

	private @Autowired AcademiaRepository academiaRepository;
	
	@RequestMapping(value = "/todos", method = RequestMethod.GET)
	public String lista(Model model){
		Iterable<Academia> academias = academiaRepository.findAll();
		
		model.addAttribute("academias", academias);
		
		return "academia-lista";
	}
	
	@RequestMapping(value = "/form", method = RequestMethod.GET)
	public String academia(Model model) {
		model.addAttribute("academia", new Academia());
		return "academia-form";
	}
	
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String save(@ModelAttribute Academia academia) {
		academiaRepository.save(academia);
		return "redirect:/academia/todos";
	}
	
	
	@RequestMapping(value = "/{academiaId}", method = RequestMethod.GET)
	public String academia(@PathVariable String academiaId, Model model) {
		Academia academia = academiaRepository.findOne(Long.valueOf(academiaId));
		
		model.addAttribute("academia", academia);
		return "academia";
	}
	
	@RequestMapping(value = "/{academiaId}", method = RequestMethod.DELETE)
	public String delete(@PathVariable String academiaId) {
		academiaRepository.delete(Long.valueOf(academiaId));
		return "redirect:/todos";
	}
	
	@RequestMapping(value = "/{academiaId}/aluno/todos", method = RequestMethod.GET)
	public String alunos(@PathVariable String academiaId, Model model) {
		
		List<Aluno> alunos = academiaRepository.findOne(Long.valueOf(academiaId)).getAlunos();
		
		model.addAttribute("alunos", alunos);
		return "aluno-lista";
	}
	
	@RequestMapping(value = "/{academiaId}/instrutor/todos", method = RequestMethod.GET)
	public String instrutores(@PathVariable String academiaId, Model model) {
		
		List<Instrutor> instrutores = academiaRepository.findOne(Long.valueOf(academiaId)).getInstrutores();
		
		model.addAttribute("instrutores", instrutores);
		return "instrutor-lista";
	}
}