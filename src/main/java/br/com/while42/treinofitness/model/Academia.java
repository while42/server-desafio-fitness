package br.com.while42.treinofitness.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import lombok.extern.log4j.Log4j;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Log4j
@Entity
public class Academia implements Cloneable {

	private @Id @GeneratedValue Long id;
	private String nome;
	private String endereco;

	@OneToOne
	private Gerente gerente;
	
	@OneToMany
	private @JsonIgnore List<Instrutor> instrutores = new ArrayList<Instrutor>();
	
	@OneToMany
	private @JsonIgnore List<Aluno> alunos = new ArrayList<Aluno>();
	

	private @JsonIgnore boolean deletado = false;
	
	public boolean isDeletado() {
		return deletado;
	}

	public void setDeletado(boolean deletado) {
		this.deletado = deletado; 
	}
	
	@Deprecated
	public Academia() {
		nome = "";
	}
	
	public Academia(String nome) {
		this.nome = nome;
	}

	public Long getId() {
		return id;
	}
	
	@Deprecated
	public void setId(Long id){
		this.id = id;
	}

	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}

	public List<Instrutor> getInstrutores() {
		return instrutores;
	}

	final void addUsuario(Usuario usuario) {
		if (usuario instanceof Aluno) {
			addAluno((Aluno) usuario);
		} else if (usuario instanceof Instrutor) {
			addInstrutor((Instrutor) usuario);
		} else {
			String username = (usuario == null) ? "NULL" : usuario.getUsername();
			log.error("Erro ao adicionar um usuario na Academia [usename: " + username + "]");
		}
	}
	
	public final void addAluno(Aluno aluno) {
		alunos.add(aluno);
	}

	public final void addInstrutor(Instrutor instrutor) {
		instrutores.add(instrutor);
	}
	
	public List<Aluno> getAlunos() {
		return alunos;
	}

	@Override
	public String toString() {
		return getNome();
	}

	public Gerente getGerente() {
		return gerente;
	}

	public void setGerente(Gerente gerente) {
		this.gerente = gerente;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public void setAlunos(List<Aluno> alunos) {
		this.alunos = alunos;
	}

	public void setInstrutores(List<Instrutor> instrutores) {
		this.instrutores = instrutores;
	}

}
