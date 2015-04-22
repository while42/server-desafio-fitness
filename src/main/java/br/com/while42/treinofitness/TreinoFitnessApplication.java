package br.com.while42.treinofitness;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import br.com.while42.treinofitness.model.Academia;
import br.com.while42.treinofitness.model.Aluno;
import br.com.while42.treinofitness.model.ExercicioRepeticoesComPeso;
import br.com.while42.treinofitness.model.ExercicioTempo;
import br.com.while42.treinofitness.model.Instrutor;
import br.com.while42.treinofitness.model.Status;
import br.com.while42.treinofitness.model.Treino;
import br.com.while42.treinofitness.repository.AcademiaRepository;
import br.com.while42.treinofitness.repository.AlunoRepository;
import br.com.while42.treinofitness.repository.InstrutorRepository;

//import org.springframework.security.core.context.SecurityContextHolder;

@SpringBootApplication
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
	public void init() {
		Status.markStartServer();
		
		// TODO: Somente para testes
		Aluno aluno = new Aluno("Aluno");
		
		Academia academia = new Academia("Academia");
		Instrutor instrutor = new Instrutor("Instrutor");
		Treino treino1 = new Treino("Treino A", "Aerobico");
		Treino treino2 = new Treino("Treino B", "Forca");
		
		treino1.addExercicio(new ExercicioTempo("Bike", 20));
		treino1.addExercicio(new ExercicioTempo("Corrida", 20));
		
		treino2.addExercicio(new ExercicioRepeticoesComPeso("Leg Press 45 graus", 4, 10, 60));
		
		// TODO: A necessidade de colocar o Aluno na Academia e setar a Academia no Aluno eh um ponto  
		// que ainda nao esta 100% finalizado. O mesmo vale para o relacionamento Aluno <-> Instrutor 
		
		academia.addInstrutor(instrutor);
		academia.addAluno(aluno);
		
		aluno.setInstrutor(instrutor);
		aluno.setAcademia(academia);
		
		aluno.addTreino(treino1);
		aluno.addTreino(treino2);

		alunoRepository.save(aluno);
		
		Instrutor instrutor2 = new Instrutor("Instrutor 2");
		Aluno aluno2 = new Aluno("Aluno 2");
		
		instrutor2.addAluno(aluno2);
		aluno2.setInstrutor(instrutor2);
		
		instrutorRepository.save(instrutor2);

		// SecurityContextHolder.clearContext();
	}
}