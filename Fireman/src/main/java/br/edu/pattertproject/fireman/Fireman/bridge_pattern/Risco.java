package br.edu.pattertproject.fireman.Fireman.bridge_pattern;

import java.util.ArrayList;
import java.util.List;

public abstract class Risco implements BridgeClassificacaoRisco {
	private List<String> fatoresRiscos;

	public Risco() {
		this.fatoresRiscos = new ArrayList<String>();
	}
	
	public List<String> getFatoresRiscos() {
		if (this.fatoresRiscos == null) {
			fatoresRiscos = new ArrayList<String>();
		}
		return fatoresRiscos;
	}

	public void setFatoresRiscos(List<String> fatoresRiscos) {
		this.fatoresRiscos = fatoresRiscos;
	}

	public Risco(List<String> fatoresRiscos) {
		this.fatoresRiscos = fatoresRiscos;
	}

}
