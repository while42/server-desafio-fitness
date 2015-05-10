package br.com.while42.treinofitness.controller.web;

import lombok.extern.log4j.Log4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import br.com.while42.treinofitness.model.Usuario;
import br.com.while42.treinofitness.repository.UsuarioRepository;

@Log4j
@Controller
public class LoginWebController {
	
	private @Autowired UsuarioRepository usuarioRepository;
	
	@RequestMapping(name = "/login", method = RequestMethod.GET)
	public String formLogin(Model model) {
		log.debug("Iniciando metodo: formLogin [method: GET] [value: /login] ");
		model.addAttribute("usuario", new Usuario("", "")); // TODO: Rever
		return "login";
	}
	
	@RequestMapping(name = "/login2", method = RequestMethod.POST)
	public String login(@ModelAttribute Usuario usuario, Model model) {
		log.debug("Iniciando metodo: login [method: POST] [value: /login]");
		
		if (usuario == null) {
			log.info("Parametro invalidos (usuario == null)");
			model.addAttribute("param.error", true);
			model.addAttribute("usuario", new Usuario("", "")); // TODO: Rever
			return "redirect:login";
		}
		
		Usuario usuarioLogado = usuarioRepository.findOneByUsernameAndSenha(usuario.getUsername(), usuario.getSenha());
		
		if (usuarioLogado == null) {
			log.info("Login Invalido - [username: " + usuario.getUsername() + "]");
			log.debug("Login Invalido - [username: " + usuario.getUsername() + "] [senha: " + usuario.getSenha() + "]");
			
			usuario.removeSenha();
			
			model.addAttribute("param.error", true);
			model.addAttribute("usuario", usuario); 
			return "redirect:login";
		}
		
//		session.setAttribute("usuarioLogado", usuarioLogado);			
		log.info("Login Efetuado - [ID: " + usuarioLogado.getId() + "] [username: " + usuarioLogado.getUsername() + "]");
		
		return "redirect:api/status";
	}

}
