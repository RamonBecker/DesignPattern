package br.edu.pattertproject.fireman.part3.command;

public class Endereco {
	private String rua;
	private String bairro;
	private String cidade;
	private String numero;

	public Endereco(String rua, String bairro, String cidade) {
		if (rua.isEmpty() || rua == null) {
			throw new IllegalArgumentException("A rua não pode ser vazio !");
		}
		if (bairro.isEmpty() || bairro == null) {
			throw new IllegalArgumentException("O Bairro não pode ser vazio !");
		}
		if (cidade.isEmpty() || cidade == null) {
			throw new IllegalArgumentException("A cidade não pode ser vazio !");
		}
		this.rua = rua;
		this.bairro = bairro;
		this.cidade = cidade;
	}

	public Endereco(String rua, String bairro, String cidade, String numero) {
		if (rua.isEmpty() || rua == null) {
			throw new IllegalArgumentException("A rua não pode ser vazio !");
		}
		if (bairro.isEmpty() || bairro == null) {
			throw new IllegalArgumentException("O Bairro não pode ser vazio !");
		}
		if (cidade.isEmpty() || cidade == null) {
			throw new IllegalArgumentException("A cidade não pode ser vazio !");
		}
		if (numero.isEmpty() || numero == null) {
			throw new IllegalArgumentException("O número não pode ser vazio !");

		}
		this.rua = rua;
		this.bairro = bairro;
		this.cidade = cidade;
		this.numero = numero;
	}

	public String getRua() {
		return rua;
	}

	public void setRua(String rua) {
		if (rua.isEmpty() || rua == null) {
			throw new IllegalArgumentException("A rua não pode ser vazio !");
		}
		this.rua = rua;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		if (bairro.isEmpty() || bairro == null) {
			throw new IllegalArgumentException("O Bairro não pode ser vazio !");
		}
		this.bairro = bairro;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		if (cidade.isEmpty() || cidade == null) {
			throw new IllegalArgumentException("A cidade não pode ser vazio !");
		}
		this.cidade = cidade;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		if (numero.isEmpty() || numero == null) {
			throw new IllegalArgumentException("O número não pode ser vazio !");

		}
		this.numero = numero;
	}

	@Override
	public String toString() {
		return "Endereco: {rua=" + rua + "}, {bairro=" + bairro + "}, {cidade=" + cidade + "}, {numero=" + numero + "}]";
	}
}
