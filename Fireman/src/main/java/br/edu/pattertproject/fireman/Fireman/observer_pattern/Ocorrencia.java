package br.edu.pattertproject.fireman.Fireman.observer_pattern;


import br.edu.pattertproject.fireman.Fireman.entites.Pessoa.Endereco;

public class Ocorrencia {
	private Endereco endereco;
	private Viatura viatura;

	public Ocorrencia(Endereco endereco, Viatura viatura) {
		this.endereco = endereco;
		this.viatura = viatura;
	}


	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	public Viatura getViatura() {
		return viatura;
	}

	public void setViatura(Viatura viatura) {
		this.viatura = viatura;
	}

}
