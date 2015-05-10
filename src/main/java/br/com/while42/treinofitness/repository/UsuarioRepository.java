package br.com.while42.treinofitness.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
//import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.data.repository.query.Param;

import br.com.while42.treinofitness.model.Usuario;

public interface UsuarioRepository extends CrudRepository<Usuario, Long> {

	@Override
	<S extends Usuario> S save(S s);

	@Override
	void delete(Long aLong);

	@Query("select u from Usuario u where u.username = :username")
	Usuario findByUsername(@Param("username") String username);
	
	@Query("select u from Usuario u where u.username = :username and u.senha = :senha")
	Usuario findOneByUsernameAndSenha(@Param("username") String username, @Param("senha") String senha);
}
