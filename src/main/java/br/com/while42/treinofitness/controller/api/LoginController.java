package br.com.while42.treinofitness.controller.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.while42.treinofitness.model.Usuario;
import br.com.while42.treinofitness.model.Login;
import br.com.while42.treinofitness.repository.UsuarioRepository;

@RestController
@RequestMapping(ApiControllerConfiguration.BASE_URL_API + "/login")
public class LoginController {

	private @Autowired UsuarioRepository usuarioRepository;
	
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<?> login(@RequestBody Login login) {
		if (login == null) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		
		Usuario usuario = usuarioRepository.findByUsername(login.getUsername());
		if (usuario.getSenha().equals(login.getSenha())) {
			return new ResponseEntity<Usuario>(usuario, HttpStatus.OK);
		}
		
		return new ResponseEntity<>(null, HttpStatus.UNAUTHORIZED);
	}
	
}
