package br.com.while42.treinofitness.model;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Status {
	
	private static String timestampStartServer;
	
	public static void markStartServer() {
		if (timestampStartServer == null) {
			timestampStartServer = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss").format(new Date());
		}
	}
	
	public String getStartedTime() {
		return timestampStartServer;
	}
}
