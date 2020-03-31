package br.edu.pattertproject.fireman.Fireman.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import br.edu.pattertproject.fireman.Fireman.bridge_pattern.BridgeClassificacaoRisco;
import br.edu.pattertproject.fireman.Fireman.bridge_pattern.Risco;
import br.edu.pattertproject.fireman.Fireman.bridge_pattern.RiscoElevado;
import br.edu.pattertproject.fireman.Fireman.bridge_pattern.RiscoLeve;
import br.edu.pattertproject.fireman.Fireman.bridge_pattern.TipoVistoria;
import br.edu.pattertproject.fireman.Fireman.bridge_pattern.edificacao.Edificacao;
import br.edu.pattertproject.fireman.Fireman.bridge_pattern.edificacao.VistoriaHabitese;
import br.edu.pattertproject.fireman.Fireman.bridge_pattern.edificacao.VistoriaParcial;
import br.edu.pattertproject.fireman.Fireman.entites.Empresa;
import br.edu.pattertproject.fireman.Fireman.entites.Vistoria;
import br.edu.pattertproject.fireman.Fireman.entites.Pessoa.Endereco;
import br.edu.pattertproject.fireman.Fireman.null_objects.NullEdificacao;
import br.edu.pattertproject.fireman.Fireman.null_objects.NullTipoVistoria;

public class DaoVistoria {

	private List<Edificacao> listEdificacoes;
	private List<String> fatoresRiscosRecebidos;

	public DaoVistoria() {
		fatoresRiscosRecebidos = new ArrayList<String>();
		listEdificacoes = new ArrayList<Edificacao>();

	}

	public void gerarClassificacao(Scanner scanner, DaoEmpresa daoEmpresa) {

		Vistoria vistoria = tipoVistoriaEscolhido(scanner, "");

		String retorno = "";

		BridgeClassificacaoRisco classificacao;

		if (vistoria instanceof VistoriaHabitese) {
			Edificacao edificacao = buscarEdificacao(scanner);

			edificacao.getVistoria().setBridgeClassificacaoRisco(new RiscoElevado());

			retorno = questionarioGerarClassificacaoRisco(scanner);

			classificacao = edificacao.getVistoria().processaClassificacaoRisco(retorno);

			edificacao.getVistoria().setBridgeClassificacaoRisco(classificacao);

			updateEdificacao(edificacao);

		}

		if (vistoria instanceof VistoriaParcial) {

			Empresa empresa = daoEmpresa.buscarEmpresa(scanner);

			VistoriaParcial vistoriaParcial = (VistoriaParcial) vistoria;

			System.out.print("Digite a area a ser utilizada pela empresa:");

			vistoriaParcial.setAreaVistoriadaParcial(scanner.nextDouble());

			empresa.setVistoria(vistoriaParcial);

			empresa.getVistoria().setBridgeClassificacaoRisco(new RiscoElevado());

			classificacao = empresa.getVistoria().processaClassificacaoRisco(retorno);

			retorno = questionarioGerarClassificacaoRisco(scanner);

			System.out.println("retorno:" + retorno);
			empresa.getVistoria().setBridgeClassificacaoRisco(classificacao);
			System.out.println("classificacao:" + empresa.getVistoria().getBridgeClassificacaoRisco());
			System.out.println(empresa);
			daoEmpresa.updateEmpresa(empresa);
		}

	}

	public String questionarioGerarClassificacaoRisco(Scanner scanner) {

		String retorno = questionarioFatorRisco(new RiscoElevado(), "Escolha a opção de risco:", scanner);

		if (retorno.isEmpty()) {
			retorno = questionarioFatorRisco(new RiscoLeve(), "Escolha a opção de risco:", scanner);
		}

		return retorno;

	}

	public Edificacao buscarEdificacao(Scanner scanner) {
		if (listEdificacoes.isEmpty()) {
			return new NullEdificacao();
		}

		int i = 0;
		for (Edificacao edificacao : listEdificacoes) {
			System.out.println("indice:" + i + ") " + edificacao);
		}
		System.out.println("Selecione a edificação pelo indice:");
		int indice = scanner.nextInt();

		if (indice < listEdificacoes.size()) {
			return listEdificacoes.get(indice);
		}

		return new NullEdificacao();

	}

	public void createEdificacao(Scanner scanner, Empresa empresa, Vistoria vistoria) {

		String rua, bairro, cidade, numero;

		System.out.println("------ Cadastro de edificacao --------");

		System.out.print("Digite o a rua");
		rua = scanner.next();

		System.out.print("Digite o bairro:");
		bairro = scanner.next();

		System.out.print("Digite a cidade:");
		cidade = scanner.next();

		System.out.print("Digite o numero:");
		numero = scanner.next();

		System.out.println("Digite a area da edificacao:");
		double area = scanner.nextDouble();

		Endereco endereco = new Endereco(rua, bairro, cidade, numero);

		Edificacao edificacao = new Edificacao();

		edificacao.setEndereco(endereco);
		edificacao.setEmpresa(empresa);
		edificacao.setArea(area);
		VistoriaHabitese vistoriaHabitese = (VistoriaHabitese) vistoria;
		vistoriaHabitese.setAreaVistoriadaHabitese(area);
		edificacao.setVistoria(vistoriaHabitese);

		listEdificacoes.add(edificacao);

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

	public void listarEdificacoes() {
		if (listEdificacoes.isEmpty()) {
			System.out.println("Não há nenhuma edificacao registrada");
			return;
		}

		for (Edificacao edificacao : listEdificacoes) {
			System.out.println(edificacao);

		}
		System.out.println("\n\n");
	}

	public Vistoria tipoVistoriaEscolhido(Scanner scanner, String op) {

		System.out.println("Tipo de vistoria a ser realizado:");

		System.out.println(op);

		for (int i = 0; i < TipoVistoria.values().length; i++) {
			System.out.println("Indice:" + i + ") " + TipoVistoria.values()[i]);
		}

		System.out.println("Selecione o tipo de vistoria pelo indice:");
		int indice = scanner.nextInt();

		if (indice < TipoVistoria.values().length) {
			return TipoVistoria.values()[indice].obterTipoVistoria();
		}

		return new NullTipoVistoria();

	}

	public void updateEdificacao(Edificacao edificacao) {

		System.out.println("Atualizando dados das edificações...");

		int i = 0;
		int auxPosicao = 0;
		for (Edificacao auxEdificacao : listEdificacoes) {
			if (auxEdificacao.getId() == edificacao.getId()) {
				auxPosicao = i;
				break;
			}
			i++;
		}

		listEdificacoes.remove(auxPosicao);
		listEdificacoes.add(edificacao);
	}

	public List<String> getFatoresRiscosRecebidos() {
		return fatoresRiscosRecebidos;
	}

	public void listarVistoria(Scanner scanner, DaoEmpresa daoEmpresa) {
		Vistoria vistoria = tipoVistoriaEscolhido(scanner,
				"Escolha o tipo de vistoria a ser listado");

		if (vistoria instanceof VistoriaParcial) {
			daoEmpresa.listarEmpresa();
			
		}
		if (vistoria instanceof VistoriaHabitese) {
			listarEdificacoes();
		}
	}

	public List<Edificacao> getListEdificacoes() {
		return listEdificacoes;
	}

}
