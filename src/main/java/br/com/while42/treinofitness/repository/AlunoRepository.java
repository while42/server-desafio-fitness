package br.com.while42.treinofitness.repository;

import org.springframework.data.repository.CrudRepository;

import br.com.while42.treinofitness.model.Aluno;

public interface AlunoRepository extends CrudRepository<Aluno, Long> {

}
