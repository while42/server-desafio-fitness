package br.com.while42.treinofitness;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RestController;

import br.com.while42.treinofitness.model.Academia;
import br.com.while42.treinofitness.model.Aluno;
import br.com.while42.treinofitness.model.Instrutor;
import br.com.while42.treinofitness.model.Treino;
import br.com.while42.treinofitness.repository.AcademiaRepository;
import br.com.while42.treinofitness.repository.AlunoRepository;
import br.com.while42.treinofitness.repository.InstrutorRepository;

//import org.springframework.security.core.context.SecurityContextHolder;

@RestController
@EnableAutoConfiguration
@ComponentScan
public class TreinoFitnessApplication {

	private @Autowired AlunoRepository alunoRepository;
	private @Autowired InstrutorRepository instrutorRepository;
	private @Autowired AcademiaRepository academiaRepository;

	public static void main(String[] args) throws Exception {
		SpringApplication.run(TreinoFitnessApplication.class, args);
	}

	@PostConstruct
	@Transactional
	public void init() {
		Aluno aluno = new Aluno("Aluno");
		
		Academia academia = new Academia("Academia");
		Instrutor instrutor = new Instrutor("Instrutor");
		//Treino treino1 = new Treino("Treino A", "Aerobico");
		//Treino treino2 = new Treino("Treino B", "Alongamento");
		
		//treino1.addExercicio(new Exercicio("Bike 20 min"));
		//treino1.addExercicio(new Exercicio("Corrida 20 min"));
		
		//treino2.addExercicio(new Exercicio("Aula de Yoga"));
		
		aluno.setInstrutor(instrutor);
		aluno.setAcademia(academia);
		//aluno.addTreino(treino1);
		//aluno.addTreino(treino2);

		alunoRepository.save(aluno);

		// SecurityContextHolder.clearContext();
	}
}