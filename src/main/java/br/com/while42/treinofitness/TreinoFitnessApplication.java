package br.com.while42.treinofitness;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;

import br.com.while42.treinofitness.model.Aluno;
import br.com.while42.treinofitness.repository.UsuarioRepository;

//import org.springframework.security.core.context.SecurityContextHolder;

@EnableAutoConfiguration
public class TreinoFitnessApplication {

	private @Autowired UsuarioRepository usuarioRepository;

	public static void main(String[] args) throws Exception {
		SpringApplication.run(TreinoFitnessApplication.class, args);
	}

	@PostConstruct
	public void init() {
		usuarioRepository.save(new Aluno("Aluno"));

		// SecurityContextHolder.clearContext();
	}
}