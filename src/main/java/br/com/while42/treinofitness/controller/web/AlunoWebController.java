package br.com.while42.treinofitness.controller.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import br.com.while42.treinofitness.model.Aluno;
import br.com.while42.treinofitness.repository.AlunoRepository;

@Controller
@RequestMapping("/aluno")
public class AlunoWebController {

	private @Autowired AlunoRepository alunoRepository;
	private @Autowired AlunoRepository academiaRepository;
	
	@RequestMapping(value = "/todos", method = RequestMethod.GET)
	public String all(Model model){
		Iterable<Aluno> academias = academiaRepository.findAll();
		
		model.addAttribute("alunos", academias);
		
		return "aluno-lista";
	} 
	
	@RequestMapping(value = "/{alunoId}", method = RequestMethod.GET)
	public String get(@PathVariable String alunoId, Model model) {
		
		Aluno aluno = alunoRepository.findOne(Long.valueOf(alunoId));
		
		if (aluno != null) {
			model.addAttribute("id", aluno.getId());
			model.addAttribute("username", aluno.getUsername());
			return "aluno";
		}

		return "aluno-inexistente";
	}

	
	@RequestMapping(value = "/{alunoId}", method = RequestMethod.DELETE)
	public String delete(@PathVariable String alunoId) {
		alunoRepository.delete(Long.valueOf(alunoId));
		
		return "redirect: /aluno/todos";
	}

	@RequestMapping(value = "/", method = {RequestMethod.POST, RequestMethod.PUT})
	public String save(@RequestBody Aluno aluno) {
		if (aluno == null) {
			// TODO: Falta msg de erro!
			return "redirect: /aluno/todos";
		}
		
		aluno = alunoRepository.save(aluno);
		return "redirect: /aluno/todos";
	}
}