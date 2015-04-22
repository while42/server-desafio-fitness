package br.com.while42.treinofitness.controller.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.while42.treinofitness.model.AbstractUsuario;
import br.com.while42.treinofitness.repository.UsuarioRepository;

@RestController
@RequestMapping(ApiControllerConfiguration.BASE_URL_API + "/usuario")
public class UsuarioController {

	private @Autowired UsuarioRepository usuarioRepository;
	
	@RequestMapping(value = "/todos", method = RequestMethod.GET)
	public Iterable<AbstractUsuario> lista() {
		return usuarioRepository.findAll();
	}
	
	@RequestMapping(value = "/{usuarioId}", method = RequestMethod.GET)
	public AbstractUsuario usuario(@PathVariable String usuarioId) {
		return usuarioRepository.findOne(Long.valueOf(usuarioId));
	}
}
