package br.edu.pattertproject.fireman.part3.FluentInterfaces;

public class Viatura {
	private String placa;
	private String modelo;
	private String fabricante;
	private String ano;
	private String combustivel;

	public Viatura contem_identificacao_de_Placa(String placa) {
		this.placa = verificarStringVaziaOuNula(placa);
		return this;
	}

	public Viatura possui_Modelo(String modelo) {
		this.modelo = modelo;
		return this;
	}

	public Viatura contem_o_fabricante(String marca) {
		this.fabricante = verificarStringVaziaOuNula(marca);
		return this;
	}

	public Viatura tem_ano_de_frabricacao(String ano) {
		this.ano = ano;
		return this;
	}

	public Viatura necessita_combustivel(String combustivel) {
		this.combustivel = verificarStringVaziaOuNula(combustivel);
		return this;
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

	private String verificarStringVaziaOuNula(String recebida) {
		if (recebida.isEmpty() || recebida == null) {
			throw new IllegalArgumentException(recebida + " não pode ser vazio ou nulo");
		}
		return recebida;
	}

	@Override
	public String toString() {
		return "Viatura: {placa=" + placa + "}, {modelo=" + modelo + "}, {fabricante=" + fabricante + "}, {ano=" + ano
				+ "}, {combustivel=" + combustivel + "}";
	}

}
