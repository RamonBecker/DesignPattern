package br.edu.pattertproject.fireman.Fireman.null_objects.risco;

import br.edu.pattertproject.fireman.Fireman.bridge_pattern.RiscoElevado;

public class NullRiscoElevado extends RiscoElevado {

	public NullRiscoElevado() {
		System.out.println("Essa atividade não se enquadra como risco elevado");
	}

	@Override
	public String toString() {
		return "";
	}

	
}
