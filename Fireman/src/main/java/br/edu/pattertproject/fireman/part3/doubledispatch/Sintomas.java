package br.edu.pattertproject.fireman.part3.doubledispatch;

public enum Sintomas {
	INTOXICACAO("Intoxicação"), 
	DESMAIO("Desmaio"), 
	ASFIXIA("Asfixia"),
	PARADA_CARDIORRESPIRATORIA("Parada Cardiorrespiratória"), 
	CONVULSAO("Convulsão");

	private String descricao;

	private Sintomas(String descricao) {
		this.descricao = descricao;
	}

	public String getDescricao() {
		return descricao;
	}

}
