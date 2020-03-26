package br.edu.pattertproject.fireman.Fireman.null_objects.risco;

import br.edu.pattertproject.fireman.Fireman.bridge_pattern.RiscoLeve;

public class NullRiscoLeve extends RiscoLeve {

	public NullRiscoLeve() {
		System.out.println("Essa atividade não se enquadra como risco leve");
	}

	@Override
	public String toString() {
		return "";
	}
	
	
}
