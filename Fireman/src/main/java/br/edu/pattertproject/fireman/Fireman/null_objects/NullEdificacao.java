package br.edu.pattertproject.fireman.Fireman.null_objects;

import java.util.Scanner;

import br.edu.pattertproject.fireman.Fireman.bridge_pattern.edificacao.Edificacao;
import br.edu.pattertproject.fireman.Fireman.dao.DaoVistoria;
import br.edu.pattertproject.fireman.Fireman.entites.Empresa;
import br.edu.pattertproject.fireman.Fireman.entites.Vistoria;
import br.edu.pattertproject.fireman.Fireman.entites.Pessoa.Endereco;

public class NullEdificacao extends Edificacao{
	
	public NullEdificacao() {
		System.out.println("Não há nenhuma edificação registrada");
	}
	
	public Endereco getEndereco() {
		return null;
	}


	public double getArea() {
		return 0;
	}
	
	public Empresa getEmpresa() {
		return null;
	}
	

	public Vistoria getVistoria() {
		return null;
	}
	
	public int getId() {
		return 0;
	}

	@Override
	public String toString() {
		return "NullEdificacao [getEndereco()=" + getEndereco() + ", getArea()=" + getArea() + ", getEmpresa()="
				+ getEmpresa() + ", getVistoria()=" + getVistoria() + ", getId()=" + getId() + "]";
	}

	
}
