package br.com.while42.treinofitness.model;

public enum TipoUsuario {
	ALUNO("/aluno/"),
	INSTRUTOR("/instrutor/"),
	ADMINISTRADOR("/admin/");
	
	private String mapping;
	private TipoUsuario(String mapping) {
		this.mapping = mapping;
	}
	
	public String getMapping() {
		return this.mapping;
	}
}
