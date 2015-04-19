package br.com.while42.model;

public class Aluno extends Usuario {
	
	private Academia academia;
	private Instrutor instrutor;

	public Aluno(String login) {
		super(login);
	}

	public Instrutor getInstrutor() {
		return instrutor;
	}

	public void setAcademia(Academia academia) {
		this.academia = academia;
	}

	public void setInstrutor(Instrutor instrutor) {
		this.instrutor = instrutor;
	}

	public Academia getAcademia() {
		return academia;
	}
}
