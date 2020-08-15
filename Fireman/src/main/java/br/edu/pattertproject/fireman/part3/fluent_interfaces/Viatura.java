package br.edu.pattertproject.fireman.part3.fluent_interfaces;

import java.util.TreeMap;

public class Viatura {
	private String placa;
	private String modelo;
	private String fabricante;
	private String ano;
	private String combustivel;
	private double velocidade;
	private TreeMap<Integer, Integer> marcha;

	public Viatura contem_identificacao_de_Placa(String placa) {
		if (placa.isEmpty() || placa == null) {
			throw new IllegalArgumentException("A placa não pode ser vazia !");
		}
		this.placa = placa;
		return this;
	}

	public Viatura possui_Modelo(String modelo) {
		if (modelo.isEmpty() || modelo == null) {
			throw new IllegalArgumentException("O modelo não pode ser vazio !");
		}
		this.modelo = modelo;
		return this;
	}

	public Viatura contem_o_fabricante(String fabricante) {
		if (fabricante.isEmpty() || fabricante == null) {
			throw new IllegalArgumentException("O fabricante não pode ser vazio !");
		}
		this.fabricante = fabricante;
		return this;
	}

	public Viatura tem_ano_de_frabricacao(String ano) {
		this.ano = ano;
		return this;
	}

	public Viatura necessita_combustivel(String combustivel) {
		if (combustivel.isEmpty() || combustivel == null) {
			throw new IllegalArgumentException("O combustível não pode ser vazio !");
		}
		this.combustivel = combustivel;
		return this;
	}

	public Viatura velocidadeAtual(double velocidade) {
		if (velocidade < 0) {
			throw new IllegalArgumentException("A velocidade não pode ser negativa !");
		}
		this.velocidade = velocidade;
		return this;
	}

	public TreeMap<Integer, Integer> getMarcha() {
		if (this.marcha == null) {
			this.marcha = new TreeMap<>();
		}
		return marcha;
	}

	public String getPlaca() {
		return placa;
	}

	public String getModelo() {
		return modelo;
	}

	public String getFabricante() {
		return fabricante;
	}

	public String getAno() {
		return ano;
	}

	public String getCombustivel() {
		return combustivel;
	}

	public double getVelocidade() {
		return velocidade;
	}

	@Override
	public String toString() {
		return "Viatura: {placa=" + placa + "}, {modelo=" + modelo + "}, {fabricante=" + fabricante + "}, {ano=" + ano
				+ "}, {combustivel=" + combustivel + "} ,{" + marcha + "}, {" + velocidade + "}";
	}

}
