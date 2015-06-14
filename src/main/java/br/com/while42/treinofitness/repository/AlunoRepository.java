package br.com.while42.treinofitness.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import br.com.while42.treinofitness.model.Aluno;

public interface AlunoRepository extends CrudRepository<Aluno, Long> {
	
	@Override
	@Query("select a from Aluno a where a.deletado = 'false'")
	public Iterable<Aluno> findAll();
	
	@Override
	@Query("update Aluno set deletado = 'true' where id = :id")
	void delete(@Param("id") Long id);
}
