package br.com.while42.treinofitness.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Exercicio {
	
	private @Id @GeneratedValue Long id;
	
	private String nome;
	private Integer series;
	private Integer repeticao;
	private Integer intervalo;
	
	@Deprecated
	public Exercicio() {
	}
	
	public Exercicio(String nome) {
		this.nome = nome;
	}

	public Integer getSeries() {
		return series;
	}

	public void setSeries(Integer series) {
		this.series = series;
	}

	public Integer getRepeticao() {
		return repeticao;
	}

	public void setRepeticao(Integer repeticao) {
		this.repeticao = repeticao;
	}

	public Integer getIntervalo() {
		return intervalo;
	}

	public void setIntervalo(Integer intervalo) {
		this.intervalo = intervalo;
	}

	public String getNome() {
		return nome;
	}
	
	@Override
	public String toString() {
		return nome;
	}
}
