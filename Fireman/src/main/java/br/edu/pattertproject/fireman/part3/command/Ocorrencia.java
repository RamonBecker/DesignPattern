package br.edu.pattertproject.fireman.part3.command;

import br.edu.pattertproject.fireman.part1.entites.person.Endereco;

public class Ocorrencia {
	private Endereco endereco;
	private String descricao;

	public Ocorrencia(Endereco endereco, String descricao) {
		if (endereco == null) {
			throw new IllegalArgumentException("O endereço não pode ser vazio");
		}
		if (descricao.isEmpty() || descricao == null) {
			throw new IllegalArgumentException("A descrição não pode ser vazio");
		}
		this.endereco = endereco;
		this.descricao = descricao;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		if (endereco == null) {
			throw new IllegalArgumentException("O endereço não pode ser vazio");
		}
		this.endereco = endereco;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		if (descricao.isEmpty() || descricao == null) {
			throw new IllegalArgumentException("A descrição não pode ser vazio");
		}
		this.descricao = descricao;
	}

	@Override
	public String toString() {
		return "Ocorrencia: {endereco=" + endereco + "}, {descricao=" + descricao + "}";
	}

}
