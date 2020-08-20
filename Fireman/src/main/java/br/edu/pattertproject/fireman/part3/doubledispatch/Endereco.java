package br.edu.pattertproject.fireman.part3.doubledispatch;

public class Endereco {
	private String rua;
	private String bairro;
	private String cidade;
	private String numero;

	public Endereco(String rua, String bairro, String cidade) {
		this.rua = rua;
		this.bairro = bairro;
		this.cidade = cidade;
	}

	public Endereco(String rua, String bairro, String cidade, String numero) {
		this.rua = rua;
		this.bairro = bairro;
		this.cidade = cidade;
		this.numero = numero;
	}

	public String getRua() {
		return rua;
	}

	public void setRua(String rua) {
		this.rua = rua;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	@Override
	public String toString() {
		return "Endereco [rua=" + rua + ", bairro=" + bairro + ", cidade=" + cidade + ", numero=" + numero + "]";
	}
}
