package br.com.while42.treinofitness.repository;

import org.springframework.data.repository.CrudRepository;
//import org.springframework.security.access.prepost.PreAuthorize;

import br.com.while42.treinofitness.model.Academia;

public interface AcademiaRepository extends CrudRepository<Academia, Long> {

	@Override
//	@PreAuthorize("hasRole('ROLE_ADMIN')")
	<S extends Academia> S save(S s);

	@Override
//	@PreAuthorize("hasRole('ROLE_ADMIN')")
	void delete(Long aLong);
}
