package br.com.while42.treinofitness;

import org.springframework.boot.*;
import org.springframework.boot.autoconfigure.*;
import org.springframework.stereotype.*;
import org.springframework.web.bind.annotation.*;

@RestController
@EnableAutoConfiguration
public class TreinoFitnessApplication {

	@RequestMapping("/all_users")
	String users() {
		return "show users";
	}

	@RequestMapping("/all_teachers")
	String teachers() {
		return "Show teacher";
	}
	
	public static void main(String[] args) throws Exception {
		SpringApplication.run(TreinoFitnessApplication.class, args);
	}

}
