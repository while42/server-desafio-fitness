package br.com.while42.treinofitness.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import br.com.while42.treinofitness.model.Instrutor;

public interface InstrutorRepository extends CrudRepository<Instrutor, Long> {
	
	@Override
	@Query("select i from Instrutor i where i.deletado = 'false'")
	public Iterable<Instrutor> findAll();

	@Override
	@Query("update Instrutor set deletado = 'true' where id = :id")
	void delete(@Param("id") Long id);
}
