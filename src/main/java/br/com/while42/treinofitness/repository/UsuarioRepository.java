package br.com.while42.treinofitness.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.security.access.prepost.PreAuthorize;

import br.com.while42.treinofitness.model.Usuario;

public interface UsuarioRepository extends CrudRepository<Usuario, Long> {

	@Override
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	<S extends Usuario> S save(S s);

	@Override
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	void delete(Long aLong);
}
