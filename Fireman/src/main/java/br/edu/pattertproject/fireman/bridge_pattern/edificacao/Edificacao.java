package br.edu.pattertproject.fireman.bridge_pattern.edificacao;

import java.util.Random;

import br.edu.pattertproject.fireman.entites.Empresa;
import br.edu.pattertproject.fireman.entites.Vistoria;
import br.edu.pattertproject.fireman.entites.person.Endereco;

public class Edificacao {
	private Endereco endereco;
	private double area;
	private Empresa empresa;
	private Vistoria vistoria;
	private int id;

	public Edificacao() {
		id = new Random().nextInt();
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

	public Vistoria getVistoria() {
		return vistoria;
	}

	public void setVistoria(Vistoria vistoria) {
		this.vistoria = vistoria;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "Edificacao [endereco=" + endereco + ", area=" + area + ", empresa=" + empresa + ", vistoria=" + vistoria
				+ ", id=" + id + "]";
	}

}
