package br.com.while42.treinofitness.controller.web;

import javax.servlet.http.HttpSession;

import lombok.extern.log4j.Log4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import br.com.while42.treinofitness.model.AbstractUsuario;
import br.com.while42.treinofitness.repository.UsuarioRepository;

@Log4j
@Controller
public class LoginWebController {
	
	private @Autowired UsuarioRepository usuarioRepository;
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String formLogin() {
		return "login";
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String efetuaLogin(AbstractUsuario usuario, HttpSession session) {
		
		AbstractUsuario usuarioLogado = usuarioRepository.findOneByUsernameAndSenha(usuario.getUsername(), usuario.getSenha());
		if (usuarioLogado != null) {
			session.setAttribute("usuarioLogado", usuarioLogado);
			
			log.info(usuarioLogado.getId() + " - " + usuarioLogado.getUsername());
			
			return "redirect:api/status";
		} else {
			log.info("NADA!: " + usuario.getUsername() + " - " + usuario.getSenha());
		}
		
		return "login";
	}

}
