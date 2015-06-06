package br.com.while42.treinofitness.controller.web;

import javax.servlet.http.HttpSession;

import lombok.extern.log4j.Log4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import br.com.while42.treinofitness.model.Academia;
import br.com.while42.treinofitness.model.Aluno;
import br.com.while42.treinofitness.model.Instrutor;
import br.com.while42.treinofitness.model.login.Logged;
import br.com.while42.treinofitness.repository.AcademiaRepository;
import br.com.while42.treinofitness.repository.AlunoRepository;
import br.com.while42.treinofitness.repository.InstrutorRepository;

@Log4j
@Controller
@RequestMapping("/aluno")
public class AlunoWebController {

	private @Autowired AlunoRepository alunoRepository;
	private @Autowired InstrutorRepository instrutorRepository;
	private @Autowired AcademiaRepository academiaRepository;

	@RequestMapping(value = "/todos", method = RequestMethod.GET)
	public String all(Model model) {
		Iterable<Aluno> alunos = alunoRepository.findAll();
		model.addAttribute("alunos", alunos);
		return "aluno-lista";
	}

	@SuppressWarnings("deprecation")
	@RequestMapping(value = "/novo", method = RequestMethod.GET)
	public String form(Model model) {
		Iterable<Instrutor> instrutores = instrutorRepository.findAll();
		Iterable<Academia> academias = academiaRepository.findAll();
		Aluno aluno = new Aluno();
		model.addAttribute("aluno", aluno);
		model.addAttribute("instrutores", instrutores);
		model.addAttribute("academias", academias);
		return "aluno-form";
	}

	@RequestMapping(value = "/{alunoId}/editar", method = RequestMethod.GET)
	public String editar(@PathVariable String alunoId, Model model,
			HttpSession session) {

		// TODO: So deveria permitir acessar os dados do aluno que o usario
		// (admin) tem permissao
		Aluno aluno = alunoRepository.findOne(Long.valueOf(alunoId));

		if (aluno != null) {
			model.addAttribute("aluno", aluno);
			model.addAttribute("treinos", aluno.getTreinos());
			model.addAttribute("instrutor", aluno.getInstrutor());
			model.addAttribute("academia", aluno.getAcademia());
			return "aluno-form";
		}
		return "aluno-inexistente";
	}

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String salvar(HttpSession session, Aluno aluno,
			@RequestParam String academiaId, @RequestParam String instrutorId) {
		log.debug("Entrou no save controller");

		Academia academia = academiaRepository.findOne(Long
				.parseLong(academiaId));
		Instrutor instrutor = instrutorRepository.findOne(Long
				.parseLong(instrutorId));

		aluno.setInstrutor(instrutor);
		aluno.setAcademia(academia);

		// TODO: So deve permitir a edicao de um aluno se o usaurio (admin) tem
		// permissao

		alunoRepository.save(aluno);
		return "redirect:/aluno/todos";
	}

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String alunoLogado(Model model, HttpSession session) {
		Logged logged = (Logged) session.getAttribute("usuarioLogged");

		Aluno aluno = alunoRepository.findOne(Long.valueOf(logged
				.getIdUsuario()));

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

		if (aluno == null) {
			return "aluno-inexistente";
		}

		model.addAttribute("aluno", aluno);
		model.addAttribute("treinos", aluno.getTreinos());
		model.addAttribute("academia", aluno.getAcademia());
		model.addAttribute("instrutor", aluno.getInstrutor());
		return "aluno";

	}

	@RequestMapping(value = "/{alunoId}", method = RequestMethod.DELETE)
	public String delete(@PathVariable String alunoId) {
		alunoRepository.delete(Long.valueOf(alunoId));
		return "redirect:/aluno/todos";
	}
}