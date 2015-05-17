package br.com.while42.treinofitness.model.login;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class Logged {
	private Long idUsuario;
	private Calendar timeStamp;
	
	public Logged(Long idUsuario) {
		this.idUsuario = idUsuario;
		this.timeStamp = new GregorianCalendar();
	}
	
	public Long getIdUsuario() {
		return idUsuario;
	}
	
	public Calendar getTimeStamp() {
		return timeStamp;
	}
}
