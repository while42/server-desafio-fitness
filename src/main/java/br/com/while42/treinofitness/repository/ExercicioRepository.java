package br.com.while42.treinofitness.repository;

import org.springframework.data.repository.CrudRepository;

import br.com.while42.treinofitness.model.AbstractExercicio;

public interface ExercicioRepository extends CrudRepository<AbstractExercicio, Long> {

}

