package br.com.while42.treinofitness.controller.web;

import javax.servlet.http.HttpSession;

import lombok.extern.log4j.Log4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import br.com.while42.treinofitness.model.Login;
import br.com.while42.treinofitness.model.Usuario;
import br.com.while42.treinofitness.repository.UsuarioRepository;

@Log4j
@Controller
public class LoginWebController {
	
	private @Autowired UsuarioRepository usuarioRepository;
	
	@RequestMapping(name = "/login", method = RequestMethod.GET)
	public String formLogin(Model model) {
		log.debug("Iniciando metodo: formLogin [method: GET] [value: /login] ");
		model.addAttribute("login", new Login()); 
		return "login";
	}
	
	// TODO: Por algum motivo nao consegui usar o mesmo name do GET
	@RequestMapping(name = "/efetuaLogin", method = RequestMethod.POST)
	public String efetuaLogin(@ModelAttribute Login login, Model model, HttpSession session) {
		log.debug("Iniciando metodo: login [method: POST] [value: /efetuaLogin]");
		
		if (login == null) {
			log.info("Parametro invalidos (usuario == null)");
			
			model.addAttribute("error", true);
			model.addAttribute("login", new Login()); 
			return "login";
		}
		
		Usuario usuarioLogado = usuarioRepository.findOneByUsernameAndSenha(login.getUsername(), login.getSenha());
		
		if (usuarioLogado == null) {
			log.info("Login Invalido - [username: " + login.getUsername() + "]");
			log.debug("Login Invalido - [username: " + login.getUsername() + "] [senha: " + login.getSenha() + "]");
			
			login.removeSenha();
			
			model.addAttribute("error", true);
			model.addAttribute("login", new Login());  
			return "login";
		}
		
		session.setAttribute("usuarioLogado", usuarioLogado);			
		log.info("Login Efetuado - [ID: " + usuarioLogado.getId() + "] [username: " + usuarioLogado.getUsername() + "]");
		
		return "redirect:api/status";
	}

}
