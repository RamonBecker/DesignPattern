package br.edu.pattertproject.fireman.part1.observer_pattern;

import br.edu.pattertproject.fireman.part1.entites.person.Endereco;

public class Ocorrencia {
	private Endereco endereco;

	public Ocorrencia(Endereco endereco) {
		this.endereco = endereco;
	}


	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}


	@Override
	public String toString() {
		return "Ocorrencia [endereco:" + endereco + "]";
	}
	
	
}
