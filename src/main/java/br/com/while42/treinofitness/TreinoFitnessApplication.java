package br.com.while42.treinofitness;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.while42.treinofitness.repository.UsuarioRepository;

@RestController
@EnableAutoConfiguration
public class TreinoFitnessApplication {
	
	@Autowired UsuarioRepository usuarioRepository;
	
	@RequestMapping("/status")
	String status() {
		return "OK!";
	}
	
	public static void main(String[] args) throws Exception {
		SpringApplication.run(TreinoFitnessApplication.class, args);
	}
	
	@PostConstruct
	public void init() {

	}
}