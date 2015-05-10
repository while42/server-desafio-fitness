package br.com.while42.treinofitness;

import javax.annotation.PostConstruct;

import lombok.extern.log4j.Log4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import br.com.while42.treinofitness.model.Academia;
import br.com.while42.treinofitness.model.Aluno;
import br.com.while42.treinofitness.model.ExercicioDistanciaPorTempo;
import br.com.while42.treinofitness.model.ExercicioPesoPorTempo;
import br.com.while42.treinofitness.model.ExercicioRepeticoesComPeso;
import br.com.while42.treinofitness.model.ExercicioTempo;
import br.com.while42.treinofitness.model.Instrutor;
import br.com.while42.treinofitness.model.Status;
import br.com.while42.treinofitness.model.Treino;
import br.com.while42.treinofitness.repository.AcademiaRepository;
import br.com.while42.treinofitness.repository.AlunoRepository;
import br.com.while42.treinofitness.repository.InstrutorRepository;

//import org.springframework.security.core.context.SecurityContextHolder;

@Log4j
@SpringBootApplication
@EnableAutoConfiguration
@ComponentScan
public class TreinoFitnessApplication {

	private @Autowired AlunoRepository alunoRepository;
	private @Autowired InstrutorRepository instrutorRepository;
	private @Autowired AcademiaRepository academiaRepository;

	public static void main(String[] args) throws Exception {
		SpringApplication.run(TreinoFitnessApplication.class, args);
		log.info("Aplicacao iniciada");
	}

	@PostConstruct
	public void init() {
		Status.markStartServer();

		// TODO: Somente para desenvolvimento

		Aluno aluno = new Aluno("aluno@aluno", "Marquinhos Frango");
		aluno.setSenha("aluno@aluno");

		Academia academia = new Academia("Academia");
		Instrutor instrutor = new Instrutor("Instrutor@Instrutor",
				"João Treinador");
		Treino treino1 = new Treino("Treino A", "Aerobico");
		Treino treino2 = new Treino("Treino B", "Forca");

		treino1.addExercicio(new ExercicioTempo("Bike", 20));
		treino1.addExercicio(new ExercicioTempo("Corrida", 20));

		treino2.addExercicio(new ExercicioRepeticoesComPeso(
				"Leg Press 45 graus", 4, 10, 60));

		// TODO: A necessidade de colocar o Aluno na Academia e setar a Academia
		// no Aluno eh um ponto
		// que ainda nao esta 100% finalizado. O mesmo vale para o
		// relacionamento Aluno <-> Instrutor

		academia.addInstrutor(instrutor);
		academia.addAluno(aluno);

		aluno.setInstrutor(instrutor);
		aluno.setAcademia(academia);

		aluno.addTreino(treino1);
		aluno.addTreino(treino2);

		alunoRepository.save(aluno);

		for (int i = 1; i < 5; i++) {
			Aluno alunoX = new Aluno("Aluno@Aluno Lero #" + i, "Aluno Frango "
					+ i);

			Academia academiaX = new Academia("Academia@Academia #" + i);
			Instrutor instrutorX = new Instrutor("Instrutor@Instrutor #" + i,
					"Maquinhos Treinador " + i);
			Treino treino1X = new Treino("Treino Maluco A", "Aerobico");
			Treino treino2X = new Treino("Treino Mais Maluco B", "Forca");
			
			if (i % 2 == 0) {
				treino1X.addExercicio(new ExercicioTempo("Bike", 20));
				treino1X.addExercicio(new ExercicioTempo("Corrida", 20));

				treino2X.addExercicio(new ExercicioRepeticoesComPeso(
						"Leg Press 45 graus", 4, 10, 60));
			} else {
				treino1X.addExercicio(new ExercicioDistanciaPorTempo("Corrida", 1000, 5));
				treino1X.addExercicio(new ExercicioPesoPorTempo("Rosca Direta", 5, 2));

				treino2X.addExercicio(new ExercicioRepeticoesComPeso(
						"Leg Press 45 graus", 10, 5, 45));
			}
			alunoX.setInstrutor(instrutorX);
			alunoX.setAcademia(academiaX);

			alunoX.addTreino(treino1X);
			alunoX.addTreino(treino2X);

			alunoRepository.save(alunoX);
		}
		
		

		Instrutor instrutor2 = new Instrutor("instrutor@username",
				"Fred Personal");		
		Aluno aluno2 = new Aluno("aluno@username", "Maria Franga");
		Academia academiaCS = new Academia("Corpo Sarado");
		Treino treinoAr = new Treino("Treino A", "Aerobico");
		Treino treinoFr = new Treino("Treino B", "Forca");

		treinoAr.addExercicio(new ExercicioTempo("Bike", 20));
		treinoAr.addExercicio(new ExercicioTempo("Corrida", 20));

		treinoFr.addExercicio(new ExercicioRepeticoesComPeso(
				"Leg Press 45 graus", 4, 10, 60));
		
		aluno2.setInstrutor(instrutor2);
		aluno2.setAcademia(academiaCS);
		aluno2.addTreino(treinoAr);
		aluno2.addTreino(treinoFr);
		
		instrutor2.addAluno(aluno2);
		
		instrutor2.setAcademia(academiaCS);
		
		academiaCS.addInstrutor(instrutor2);
		academiaCS.addAluno(aluno2);
		
		alunoRepository.save(aluno2);
		instrutorRepository.save(instrutor2);
		academiaRepository.save(academiaCS);
		
		// SecurityContextHolder.clearContext();
	}
}