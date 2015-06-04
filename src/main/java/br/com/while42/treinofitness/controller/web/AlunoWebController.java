package br.com.while42.treinofitness.controller.web;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import br.com.while42.treinofitness.model.Aluno;
import br.com.while42.treinofitness.model.login.Logged;
import br.com.while42.treinofitness.model.treino.Treino;
import br.com.while42.treinofitness.repository.AlunoRepository;

@Controller
@RequestMapping("/aluno")
public class AlunoWebController {

	private @Autowired AlunoRepository alunoRepository;
	
	@RequestMapping(value = "/todos", method = RequestMethod.GET)
	public String all(Model model){
		Iterable<Aluno> alunos = alunoRepository.findAll();
		
		model.addAttribute("alunos", alunos);
		
		return "aluno-lista";
	} 
	
	@RequestMapping(value = "/form", method = RequestMethod.GET)
	public String form(Model model){
		model.addAttribute("aluno", new Aluno());
		return "aluno-form";
	}
	
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String salvar(@ModelAttribute Aluno aluno){
		alunoRepository.save(aluno);
		return "redirect:/aluno/todos";
	}
	
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String alunoLogado(Model model, HttpSession session) {
		Logged logged = (Logged) session.getAttribute("usuarioLogged");
		if (logged == null) {
			return "redirect:/login";
		}
		
		Aluno aluno = alunoRepository.findOne(Long.valueOf(logged.getIdUsuario()));
		
		if (aluno != null) {
			model.addAttribute("aluno", aluno);
			model.addAttribute("treinos", aluno.getTreinos());
			model.addAttribute("instrutor", aluno.getInstrutor());
			model.addAttribute("academia", aluno.getAcademia());
			return "aluno";
		}

		return "aluno-inexistente";
	}
	
	@RequestMapping(value = "/{alunoId}", method = RequestMethod.GET)
	public String aluno(@PathVariable String alunoId, Model model) {
		
		Aluno aluno = alunoRepository.findOne(Long.valueOf(alunoId));
		
		if (aluno != null) {
			model.addAttribute("aluno", aluno);
			model.addAttribute("treinos", aluno.getTreinos());
			model.addAttribute("instrutor", aluno.getInstrutor());
			model.addAttribute("academia", aluno.getAcademia());
			return "aluno";
		}

		return "aluno-inexistente";
	}
	
	
	@RequestMapping(value = "/{alunoId}", method = RequestMethod.DELETE)
	public String delete(@PathVariable String alunoId) {
		alunoRepository.delete(Long.valueOf(alunoId));
		
		return "redirect:/aluno/todos";
	}

	@RequestMapping(value = "/", method = {RequestMethod.POST, RequestMethod.PUT})
	public String save(@RequestBody Aluno aluno) {
		if (aluno == null) {
			// TODO: Falta msg de erro!
			return "redirect:/aluno/todos";
		}
		
		aluno = alunoRepository.save(aluno);
		return "redirect:/aluno/todos";
	}
}