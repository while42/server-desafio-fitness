package br.com.while42.treinofitness.controller.web;

import java.util.List;

import lombok.extern.log4j.Log4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import br.com.while42.treinofitness.model.Academia;
import br.com.while42.treinofitness.model.Aluno;
import br.com.while42.treinofitness.model.Instrutor;
import br.com.while42.treinofitness.repository.AcademiaRepository;

@Log4j
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
		log.debug("Entrou no metodo editar - " + academia.getNome() + " - " + academia.getId());
		model.addAttribute("academia", academia);
		return "academia-form";
	}
	
	@RequestMapping(value = "/salvar", method = RequestMethod.POST)
	public String salvar(@ModelAttribute Academia academia) {
		if(academia.getId() != null){
			Academia academiaComDadosAntigos = academiaRepository.findOne(academia.getId());
			academiaComDadosAntigos.setNome(academia.getNome());
			academiaComDadosAntigos.setEndereco(academia.getEndereco());
			academiaRepository.save(academiaComDadosAntigos);
		} else {
			academiaRepository.save(academia);
		}
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
	
	@RequestMapping(value = "/{academiaId}/excluir", method = RequestMethod.GET)
	public String deletaAcademia(@PathVariable Long academiaId, Model model) {
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