package br.edu.pattertproject.fireman.part3.doubledispatch;

public abstract class Ocorrencia {
	private Endereco endereco;

	public Ocorrencia(Endereco endereco) {
		if (endereco == null) {
			throw new IllegalArgumentException("O endereço não pode ser vazio !");
		}
		this.endereco = endereco;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		if (endereco == null) {
			throw new IllegalArgumentException("O endereço não pode ser vazio !");
		}
		this.endereco = endereco;
	}

}
