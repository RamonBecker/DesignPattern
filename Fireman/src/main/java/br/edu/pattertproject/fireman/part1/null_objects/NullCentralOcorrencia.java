package br.edu.pattertproject.fireman.part1.null_objects;

import br.edu.pattertproject.fireman.part1.observer_pattern.CentralDeOcorrencia;


public class NullCentralOcorrencia extends CentralDeOcorrencia {
	
	public NullCentralOcorrencia() {
		System.out.println("Não foi possível buscar a central de ocorrência");
	}
	
	@Override
	public String getEstadoViatura() {
		return null;
	}
	
	@Override
	public void setEstadoViatura(String estadoViatura) {
		super.setEstadoViatura(null);
	}
}
