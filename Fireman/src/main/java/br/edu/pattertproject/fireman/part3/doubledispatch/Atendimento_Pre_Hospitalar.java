package br.edu.pattertproject.fireman.part3.doubledispatch;

public class Atendimento_Pre_Hospitalar extends Ocorrencia {

	private Sintomas sintomas;

	public Atendimento_Pre_Hospitalar(Endereco endereco) {
		super(endereco);
	}

	public Sintomas getSintomas() {
		return sintomas;
	}

	public void setSintomas(Sintomas sintomas) {
		if (sintomas == null) {
			throw new IllegalArgumentException("O sintoma não pode ser vazio !");
		}
		this.sintomas = sintomas;
	}

}
