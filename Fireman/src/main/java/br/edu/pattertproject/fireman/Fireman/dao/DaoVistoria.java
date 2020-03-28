package br.edu.pattertproject.fireman.Fireman.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import br.edu.pattertproject.fireman.Fireman.bridge_pattern.Risco;
import br.edu.pattertproject.fireman.Fireman.bridge_pattern.TipoVistoria;
import br.edu.pattertproject.fireman.Fireman.entites.Vistoria;
import br.edu.pattertproject.fireman.Fireman.null_objects.NullTipoVistoria;

public class DaoVistoria {

	private List<String> questionarioFatorDeRisco;
	private List<String> fatoresRiscosRecebidos;

	public DaoVistoria() {

		questionarioFatorDeRisco = new ArrayList<String>();
		fatoresRiscosRecebidos = new ArrayList<String>();

		questionarioFatorDeRisco.add("gas: P13, P45 ou canalizado");
		questionarioFatorDeRisco.add("deposito de combustivel ou liquido inflamavel");
		questionarioFatorDeRisco.add("deposito de explosivos");

	}

	public String questionarioFatorRisco(Risco risco, String operacao, Scanner scanner) {

		System.out.println(operacao);
		System.out.println("Digite as opções a seguir:");

		int i = 0;
		for (i = 0; i < risco.getFatoresRiscos().size(); i++) {
			System.out.println(i + "-" + risco.getFatoresRiscos().get(i));
		}

		System.out.println((i) + "-Nenhuma das opções");

		int leitura = scanner.nextInt();

		if (leitura < risco.getFatoresRiscos().size()) {
			return risco.getFatoresRiscos().get(leitura);
		}

		return "";
	}

	public List<String> getQuestionarioFatorDeRisco() {
		return questionarioFatorDeRisco;
	}

	public List<String> getFatoresRiscosRecebidos() {
		return fatoresRiscosRecebidos;
	}

	public void solicitarVistoria() {
		/// Empresa empresa = new Empresa("Empresa", "Empresa tal tal");

	}

	public Vistoria tipoVistoriaEscolhido(Scanner scanner) {

		System.out.println("Tipo de vistoria a ser realizado:");

		for (int i = 0; i < TipoVistoria.values().length; i++) {
			System.out.println("Indice:" + i + ")" + TipoVistoria.values()[i]);
		}

		System.out.println("Selecione o tipo de vistoria pelo indice:");
		int indice = scanner.nextInt();

		if (indice < TipoVistoria.values().length) {
			return TipoVistoria.values()[indice].obterTipoVistoria();
		}

		return new NullTipoVistoria();

	}

}
