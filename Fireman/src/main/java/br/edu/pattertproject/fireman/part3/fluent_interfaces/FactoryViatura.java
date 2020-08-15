package br.edu.pattertproject.fireman.part3.fluent_interfaces;

public class FactoryViatura {

	public static Viatura criarPlaca(String placa) {
		Viatura viatura = new Viatura().contem_identificacao_de_Placa(placa);
		return viatura;
	}

	public static Viatura criarModelo(String modelo) {
		Viatura viatura = new Viatura().possui_Modelo(modelo);
		return viatura;
	}

	public static Viatura criarFabricante(String fabricante) {
		Viatura viatura = new Viatura().contem_o_fabricante(fabricante);
		return viatura;
	}

	public static Viatura criarAnoFabricacao(String anoFabricacao) {
		Viatura viatura = new Viatura().tem_ano_de_frabricacao(anoFabricacao);
		return viatura;
	}

	public static Viatura criarTipoCombustivel(String tipoCombustivel) {
		Viatura viatura = new Viatura().necessita_combustivel(tipoCombustivel);
		return viatura;
	}

	public static Viatura criar_Placa_Modelo_Fabricante_Ano_TipoCombustivel(String placa, String modelo,
			String fabricante, String ano, String tipoCombustivel) {
		Viatura viatura = new Viatura().contem_identificacao_de_Placa(placa).possui_Modelo(modelo)
				.contem_o_fabricante(fabricante).tem_ano_de_frabricacao(ano).necessita_combustivel(tipoCombustivel);
		return viatura;
	}
}
