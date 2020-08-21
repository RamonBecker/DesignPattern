package br.edu.pattertproject.fireman.part3.facade.model.empresa;

public class Empresa extends PessoaJuridica {
	private String ocupacao;

	public Empresa() {

	}

	public Empresa(Documento documento, String razaoSocial, String nomeFantasia, String ocupacao) {
		super(documento, razaoSocial, nomeFantasia);
		if (ocupacao.isEmpty() || ocupacao == null) {
			throw new IllegalArgumentException("A ocupação não pode ser vazia");
		}
		this.ocupacao = ocupacao;
	}

	public String getOcupacao() {
		return ocupacao;
	}

	public void setOcupacao(String ocupacao) {
		if (ocupacao.isEmpty() || ocupacao == null) {
			throw new IllegalArgumentException("A ocupação não pode ser vazia");
		}
		this.ocupacao = ocupacao;
	}

	@Override
	public String toString() {
		return "Empresa [ocupacao=" + ocupacao + "]";
	}

}
