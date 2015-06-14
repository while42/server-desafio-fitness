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
	@Query("select u from Usuario u where u.deletado = 'false'")
	public Iterable<Usuario> findAll();
	
	@Override
	@Query("update Usuario set deletado = 'true' where id = :id")
	void delete(@Param("id") Long id);

	@Query("select u from Usuario u where u.username = :username and u.deletado = 'false'")
	Usuario findByUsername(@Param("username") String username);
	
	@Query("select u from Usuario u where u.username = :username and u.senha = :senha and u.deletado = 'false'")
	Usuario findOneByUsernameAndSenha(@Param("username") String username, @Param("senha") String senha);
}
