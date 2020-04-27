package br.edu.pattertproject.fireman.part1.null_objects;

import br.edu.pattertproject.fireman.part1.bridge_pattern.Edificacao;
import br.edu.pattertproject.fireman.part1.entites.Empresa;
import br.edu.pattertproject.fireman.part1.entites.Vistoria;
import br.edu.pattertproject.fireman.part1.entites.person.Endereco;

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
