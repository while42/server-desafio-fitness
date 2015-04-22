package br.com.while42.treinofitness.repository;

import org.springframework.data.repository.CrudRepository;
//import org.springframework.security.access.prepost.PreAuthorize;


import br.com.while42.treinofitness.model.AbstractUsuario;

public interface UsuarioRepository extends CrudRepository<AbstractUsuario, Long> {

	@Override
//	@PreAuthorize("hasRole('ROLE_ADMIN')")
	<S extends AbstractUsuario> S save(S s);

	@Override
//	@PreAuthorize("hasRole('ROLE_ADMIN')")
	void delete(Long aLong);

	AbstractUsuario findByUsername(String username);
}
