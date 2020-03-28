package br.edu.pattertproject.fireman.Fireman.entites.Pessoa;

import br.edu.pattertproject.fireman.Fireman.entites.Pessoa.documento.Documento;

public class PessoaFisica extends Pessoa {
	private String nome;
	private String sobrenome;

	public PessoaFisica(Documento documento) {
		super(documento);
	}

	public PessoaFisica(String nome, String sobrenome) {
		super(null);
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

	@Override
	public String toString() {
		return "Pessoa Fisica nome:" + nome + ", sobrenome:" + sobrenome +"\n";
	}

}
