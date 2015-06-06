package br.com.while42.treinofitness.controller.api;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.while42.treinofitness.model.Usuario;
import br.com.while42.treinofitness.model.login.Logged;
import br.com.while42.treinofitness.model.login.Login;
import br.com.while42.treinofitness.repository.UsuarioRepository;

@RestController
@RequestMapping(ApiControllerConfiguration.BASE_URL_API)
public class LoginController {

	private @Autowired UsuarioRepository usuarioRepository;

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public ResponseEntity<?> login(@RequestBody Login login, HttpSession session) {
		if (login == null) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}

		Usuario usuarioLogado = usuarioRepository.findOneByUsernameAndSenha(login.getUsername(), login.getSenha());

		if (usuarioLogado == null) {
			return new ResponseEntity<>(null, HttpStatus.UNAUTHORIZED);
		}

		session.setAttribute("usuarioLogged", new Logged(usuarioLogado.getId(), usuarioLogado.getTipoUsuario()));	
		return new ResponseEntity<Usuario>(usuarioLogado, HttpStatus.OK);
	}

	@RequestMapping(value = "/logout", method = RequestMethod.POST)
	public ResponseEntity<?> logout(@RequestBody Login login, HttpSession session) {
		if (login == null) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}

		Usuario usuarioLogado = usuarioRepository.findOneByUsernameAndSenha(login.getUsername(), login.getSenha());

		if (usuarioLogado == null) {
			return new ResponseEntity<>(null, HttpStatus.UNAUTHORIZED);
		}

		session.removeAttribute("usuarioLogged");
		return new ResponseEntity<Usuario>(usuarioLogado, HttpStatus.OK);
	}
}
