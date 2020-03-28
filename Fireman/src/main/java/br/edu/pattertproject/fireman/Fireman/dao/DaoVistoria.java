package br.edu.pattertproject.fireman.Fireman.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class DaoVistoria {

	private List<String> questionarioFatorDeRisco;
	private List<String> questionarioFatorTipoEstabelecimento;
	private List<String> fatoresRiscosRecebidos;

	public DaoVistoria() {

		questionarioFatorDeRisco = new ArrayList<String>();
		questionarioFatorTipoEstabelecimento = new ArrayList<String>();
		fatoresRiscosRecebidos = new ArrayList<String>();

		questionarioFatorDeRisco.add("gas: P13, P45 ou canalizado");
		questionarioFatorDeRisco.add("deposito de combustivel ou liquido inflamavel");
		questionarioFatorDeRisco.add("deposito de explosivos");

		questionarioFatorTipoEstabelecimento.add("A empresa não possui area edificada");
		questionarioFatorTipoEstabelecimento.add("Comercio varejista");
		questionarioFatorTipoEstabelecimento.add("Comercio de produtos eletronicos");
		questionarioFatorTipoEstabelecimento.add("Restaurantes, lanchonetes ou similares");
		questionarioFatorTipoEstabelecimento.add("Borracharia");
		questionarioFatorTipoEstabelecimento.add("Mecânica");
	}

	public <T> void questionarioParaVistoria(List<T> questionario, String operacao, Scanner scanner) {

		System.out.println(operacao);
		System.out.println("Digite as opções a seguir:");

		int i = 0;
		for (i = 0; i < questionario.size(); i++) {
			System.out.println(i + "-" + questionario.get(i));
		}

		System.out.println((i) + "-Nenhuma das opções");

		int leitura = scanner.nextInt();

		if (leitura < questionario.size()) {
			fatoresRiscosRecebidos.add(String.valueOf(questionario.get(leitura)));
		}

	}

	public List<String> getQuestionarioFatorDeRisco() {
		return questionarioFatorDeRisco;
	}

	public List<String> getQuestionarioFatorTipoEstabelecimento() {
		return questionarioFatorTipoEstabelecimento;
	}

	public List<String> getFatoresRiscosRecebidos() {
		return fatoresRiscosRecebidos;
	}
	
	public void solicitarVistoria() {
	///	Empresa empresa = new Empresa("Empresa", "Empresa tal tal");
		
		
	}
	
}
