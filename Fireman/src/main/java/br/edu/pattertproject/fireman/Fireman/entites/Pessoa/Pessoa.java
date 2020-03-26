package br.edu.pattertproject.fireman.Fireman.entites.Pessoa;

import br.edu.pattertproject.fireman.Fireman.entites.Pessoa.documento.Documento;

public abstract class Pessoa {
	private String nome;
	private String sobrenome;
	private Documento documento;
	private Endereco endereco;

	public Pessoa(String nome) {
		this.nome = nome;
	}

	public Pessoa(String nome, String sobrenome) {
		this.nome = nome;
		this.sobrenome = sobrenome;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSobrenome() {
		return sobrenome;
	}

	public void setSobrenome(String sobrenome) {
		this.sobrenome = sobrenome;
	}

	public Documento getDocumento() {
		return documento;
	}

	public void setDocumento(Documento documento) {
		this.documento = documento;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	@Override
	public String toString() {
		return "Pessoa [nome=" + nome + ", sobrenome=" + sobrenome + "]";
	}

}
