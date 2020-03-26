package br.edu.pattertproject.fireman.Fireman.null_objects.risco;

import br.edu.pattertproject.fireman.Fireman.bridge_pattern.RiscoMedio;

public class NullRiscoMedio extends RiscoMedio {

	public NullRiscoMedio() {
		System.out.println("Essa atividade não se enquadra como risco medio");
	}

	@Override
	public String toString() {
		return "";
	}

}
