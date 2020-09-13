package br.edu.pattertproject.fireman.part3.doubledispatch;

import java.util.ArrayList;
import java.util.List;


public abstract class Ocorrencia {
	private Endereco endereco;
	private List<Equipamento> lista_equipamentos;
	

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
	public List<Equipamento> getLista_Equipamentos() {
		if(this.lista_equipamentos == null) {
			this.lista_equipamentos = new ArrayList<Equipamento>();
		}
		return lista_equipamentos;
	}

}
