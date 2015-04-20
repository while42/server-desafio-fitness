package br.com.while42.treinofitness.repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;

import br.com.while42.treinofitness.model.Academia;
import br.com.while42.treinofitness.model.Aluno;
import br.com.while42.treinofitness.model.Usuario;

public class UsuarioRepositoryTest {

	private UsuarioRepository usuarioRepository;
	private AcademiaRepository academiaRepository;
	private EntityManager em;

	@Before
	public void setUp() {
		EntityManagerFactory factory = Persistence
				.createEntityManagerFactory("jpa.sample.plain");
		em = factory.createEntityManager();

		usuarioRepository = (UsuarioRepository) new SimpleJpaRepository<Usuario, Long>(
				Usuario.class, em);

		em.getTransaction().begin();
	}

	@After
	public void tearDown() {
		em.getTransaction().rollback();
	}

	public void save() {
		Academia vip = academiaRepository.save(new Academia("Academia 1"));

		Aluno aluno = new Aluno("Aluno");
		aluno.setAcademia(vip);

		aluno = usuarioRepository.save(aluno);

		Assert.assertEquals("Academia 1",
				usuarioRepository.findOne(aluno.getId()));
	}

}
