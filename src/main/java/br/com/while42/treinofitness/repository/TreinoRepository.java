package br.com.while42.treinofitness.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import br.com.while42.treinofitness.model.treino.Treino;

public interface TreinoRepository extends CrudRepository<Treino, Long> {

	@Override
	@Query("select t from Treino t where t.deletado = 'false'")
	public Iterable<Treino> findAll();
	
	@Override
	@Query("update Treino set deletado = 'true' where id = :id")
	void delete(@Param("id") Long id);
}
