package br.com.while42.treinofitness.repository;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import br.com.while42.treinofitness.model.treino.AbstractExercicio;

public interface ExercicioRepository extends CrudRepository<AbstractExercicio, Long> {

	@Override
	@Query("select a from AbstractExercicio a where a.deletado = 'false'")
	public Iterable<AbstractExercicio> findAll();
	
	@Override
	@Modifying
	@Query("update AbstractExercicio set deletado = 'true' where id = :id")
	void delete(@Param("id") Long id);
}

