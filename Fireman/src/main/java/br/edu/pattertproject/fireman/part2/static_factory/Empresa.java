package br.edu.pattertproject.fireman.part2.static_factory;

import br.edu.pattertproject.fireman.part1.entites.documents.Documento;
import br.edu.pattertproject.fireman.part2.static_factory.PessoaJuridica;

public class Empresa extends PessoaJuridica {

	private String ocupacao;

	public Empresa() {
		super();
	}

	public Empresa(String ocupacao) {
		this.ocupacao = ocupacao;
		this.nomeFantasia = "";
		this.razaoSocial = "";
	}

	public Empresa(Documento documento, String razaoSocial, String nomeFantasia, String ocupacao) {
		super(documento, razaoSocial, nomeFantasia);
		this.ocupacao = ocupacao;
	}

	public Empresa(String razaoSocial, String nomeFantasia) {
		super(razaoSocial, nomeFantasia);
	}

	public String getOcupacao() {
		return ocupacao;
	}

	public void setOcupacao(String ocupacao) {
		this.ocupacao = ocupacao;
	}

	@Override
	public String toString() {
		return "Empresa [ocupacao=" + ocupacao + ", razaoSocial=" + razaoSocial + ", nomeFantasia=" + nomeFantasia
				+ "]";
	}


	
	
}
