package br.com.while42.treinofitness.repository;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
//import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.data.repository.query.Param;

import br.com.while42.treinofitness.model.Academia;

public interface AcademiaRepository extends CrudRepository<Academia, Long> {

	@Override
	@Query("select a from Academia a where a.deletado is false")
	public Iterable<Academia> findAll();
	
	@Override
	@Modifying
	@Query("update Academia set deletado = true where id = :id")
	void delete(@Param("id") Long id);
	
	
}
