package br.edu.pattertproject.fireman.Fireman.bridge_pattern.edificacao;

import br.edu.pattertproject.fireman.Fireman.entites.Empresa;
import br.edu.pattertproject.fireman.Fireman.entites.Pessoa.Endereco;

public class Edificacao {
	private String nome;
	private Endereco endereco;
	private double area;
	private Empresa empresa;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	public double getArea() {
		return area;
	}

	public void setArea(double area) {
		this.area = area;
	}

	public Empresa getEmpresa() {
		return empresa;
	}

	public void setEmpresa(Empresa empresa) {
		this.empresa = empresa;
	}

}
