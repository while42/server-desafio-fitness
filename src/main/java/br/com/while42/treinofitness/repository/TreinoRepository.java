package br.com.while42.treinofitness.repository;

import org.springframework.data.repository.CrudRepository;

import br.com.while42.treinofitness.model.Treino;

public interface TreinoRepository extends CrudRepository<Treino, Long> {

}
