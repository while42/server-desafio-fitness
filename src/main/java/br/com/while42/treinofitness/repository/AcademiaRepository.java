package br.com.while42.treinofitness.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
//import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.data.repository.query.Param;

import br.com.while42.treinofitness.model.Academia;

public interface AcademiaRepository extends CrudRepository<Academia, Long> {

	
	@Override
	<S extends Academia> S save(S s);

	@Override
	@Query("select a from Academia a where a.deletado = 'false'")
	public Iterable<Academia> findAll();
	
	@Override
	@Query("update Academia set deletado = 'true' where id = :id")
	void delete(@Param("id") Long id);
	
}
