package br.com.while42.treinofitness.repository;

import org.springframework.data.repository.CrudRepository;

import br.com.while42.treinofitness.model.Exercicio;

public interface ExercicioRepository extends CrudRepository<Exercicio, Long> {

}

