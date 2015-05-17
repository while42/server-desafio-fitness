package br.com.while42.treinofitness.model.login;

import java.util.Calendar;
import java.util.GregorianCalendar;

import br.com.while42.treinofitness.model.TipoUsuario;

public class Logged {
	private Long idUsuario;
	private TipoUsuario tipoUsuario;
	private Calendar timeStamp;
	
	public Logged(Long idUsuario, TipoUsuario tipoUsuario) {
		this.idUsuario = idUsuario;
		this.tipoUsuario = tipoUsuario;
		this.timeStamp = new GregorianCalendar();
	}
	
	public Long getIdUsuario() {
		return idUsuario;
	}
	
	public TipoUsuario getTipoUsuario() {
		return tipoUsuario;
	}
	
	public Calendar getTimeStamp() {
		return timeStamp;
	}
}
