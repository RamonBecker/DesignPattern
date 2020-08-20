package br.edu.pattertproject.fireman.part3.doubledispatch;

import java.util.HashMap;


public abstract class Ocorrencia {
	private Endereco endereco;
	private HashMap<Integer, Equipamento> lista_Equipamentos_Utilizados;

	public Ocorrencia(Endereco endereco) {
		if (endereco == null) {
			throw new IllegalArgumentException("O endereço não pode ser vazio !");
		}
		this.endereco = endereco;
	}

	public abstract void addPropriedades(RelatorioOcorrencia relatorioOcorrencia);

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		if (endereco == null) {
			throw new IllegalArgumentException("O endereço não pode ser vazio !");
		}
		this.endereco = endereco;
	}

	public HashMap<Integer, Equipamento> getLista_Equipamentos_Utilizados() {
		if (lista_Equipamentos_Utilizados == null) {
			lista_Equipamentos_Utilizados = new HashMap<Integer, Equipamento>();
		}
		return lista_Equipamentos_Utilizados;
	}

	@Override
	public String toString() {
		return "Ocorrencia [endereco=" + endereco + ", lista_Equipamentos_Utilizados=" + lista_Equipamentos_Utilizados
				+ "]";
	}

}
