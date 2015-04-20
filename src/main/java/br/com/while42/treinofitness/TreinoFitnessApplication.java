package br.com.while42.treinofitness;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.while42.treinofitness.model.Aluno;
import br.com.while42.treinofitness.repository.UsuarioRepository;

//import org.springframework.security.core.context.SecurityContextHolder;

@RestController
@EnableAutoConfiguration
public class TreinoFitnessApplication {

	private @Autowired UsuarioRepository usuarioRepository;

	@RequestMapping("/ok")
	public String status() {
		return "Ok!";
	}
	
	public static void main(String[] args) throws Exception {
		SpringApplication.run(TreinoFitnessApplication.class, args);
	}

	@PostConstruct
	public void init() {
		usuarioRepository.save(new Aluno("Aluno"));

		// SecurityContextHolder.clearContext();
	}
}