package br.com.while42.treinofitness.repository;

import org.springframework.data.repository.CrudRepository;

import br.com.while42.treinofitness.model.treino.Treino;

public interface TreinoRepository extends CrudRepository<Treino, Long> {

}
