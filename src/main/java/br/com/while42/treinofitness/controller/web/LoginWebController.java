package br.com.while42.treinofitness.controller.web;

import javax.servlet.http.HttpSession;

import lombok.extern.log4j.Log4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import br.com.while42.treinofitness.model.Usuario;
import br.com.while42.treinofitness.repository.UsuarioRepository;

@Log4j
@Controller
public class LoginWebController {
	
	private @Autowired UsuarioRepository usuarioRepository;
	
	@RequestMapping(value="/login", method = RequestMethod.GET)
	public String formLogin() {
		log.debug("Iniciando metodo: formLogin [method: GET] [value: /login]");
		return "login";
	}
	
	@RequestMapping(value="/login", method = RequestMethod.POST)
	public String login(@ModelAttribute Usuario usuario) {
		log.debug("Iniciando metodo: login [method: POST] [value: /login]");
		return "login";
	}
	
	
	public String efetuaLogin(@ModelAttribute Usuario usuario, HttpSession session) {
		log.debug("Iniciando metodo: efetuaLogin");
		
		if (usuario == null) {
			log.info("Parametro invalidos (usuario == null)");
			return "login";
		}
		
		Usuario usuarioLogado = usuarioRepository.findOneByUsernameAndSenha(usuario.getUsername(), usuario.getSenha());
		
		if (usuarioLogado != null) {
			session.setAttribute("usuarioLogado", usuarioLogado);			
			log.info("Login Efetuado - [ID: " + usuarioLogado.getId() + "] [username: " + usuarioLogado.getUsername() + "]");
			
			return "redirect:api/status";
		} else {
			log.info("Login Invalido - [username: " + usuario.getUsername() + "]");
			log.debug("Login Invalido - [username: " + usuario.getUsername() + "] [senha: " + usuario.getSenha() + "]");
		}
		
		log.debug("Finalizando metodo: efetuaLogin");
		return "login";
	}

}
