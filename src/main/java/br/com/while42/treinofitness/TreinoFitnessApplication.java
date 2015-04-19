package br.com.while42.treinofitness;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@EnableAutoConfiguration
public class TreinoFitnessApplication {
	
	@RequestMapping("/status")
	String status() {
		return "OK!";
	}
	
	public static void main(String[] args) throws Exception {
		SpringApplication.run(TreinoFitnessApplication.class, args);
	}
}