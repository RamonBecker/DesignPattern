package br.edu.pattertproject.fireman.Fireman.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import br.edu.pattertproject.fireman.Fireman.entites.Empresa;
import br.edu.pattertproject.fireman.Fireman.entites.Pessoa.documento.Documento;
import br.edu.pattertproject.fireman.Fireman.entites.Pessoa.documento.ValidadorCNPJ;
import br.edu.pattertproject.fireman.Fireman.null_objects.NullEmpresa;
import br.edu.pattertproject.fireman.Fireman.null_objects.NullTipoTaxa;
import br.edu.pattertproject.fireman.Fireman.state_pattern.TaxaQuitada;
import br.edu.pattertproject.fireman.Fireman.strategy_pattern.StrategyTaxa;

public class DaoEmpresa {

	private List<Empresa> listEmpresa;

	public DaoEmpresa() {
		listEmpresa = new ArrayList<Empresa>();
	}

	public Empresa createEmpresa(Scanner scanner) {

		System.out.println("------------ Empresa ------------ ");

		String cnpj, nomeFantasia, razaoSocial, ocupacao;

		System.out.print("Digite o CNPJ:");

		cnpj = scanner.next();

		Documento documento = new Documento(cnpj, new ValidadorCNPJ());

		System.out.print("Digite o nome fantansia:");

		nomeFantasia = scanner.next();

		System.out.print("Digite a razao social:");

		razaoSocial = scanner.next();

		System.out.print("Digite a ocupação da empresa");

		ocupacao = scanner.next();

		Empresa empresa = new Empresa(documento, nomeFantasia, razaoSocial, ocupacao);

		System.out.println("Empresa cadastrada com sucesso !");
		System.out.println(empresa);

		System.out.println("\n\n");

		return empresa;
	}

	public int tipoTaxaEscolhido(Scanner scanner, Object[] object, String op) {

		System.out.println(op);

		for (int i = 0; i < object.length; i++) {
			System.out.println("Indice: " + i +") "+ " " + object[i]);

		}

		System.out.print("Selecione o tipo de taxa pelo indice:");
		int indice = scanner.nextInt();

		if (indice < object.length) {
			return indice;
		}
		throw new NullTipoTaxa("Não foi possível escolher o tipo de taxa");

	}

	public Empresa pagarTaxa(Empresa empresa) {

		System.out.println("Realizando tentativa de pagamento");
		empresa.setInterfaceEstado(new TaxaQuitada());

		if (empresa.getInterfaceEstado().processaPagamento(empresa) instanceof TaxaQuitada) {
			System.out.println("Não a taxa pendente");
		} else {
			System.out.println("Quitando taxa");
			empresa.setTaxa(0);
			System.out.println(empresa);
			System.out.println("Taxa quitada");
		}

		return empresa;

	}

	public Empresa buscarEmpresa(Scanner scanner) {

		System.out.println("Buscando empresas ......");

		if (listEmpresa.isEmpty()) {
			return new NullEmpresa();
		}

		System.out.println("---------------- Listando as empresas ---------------- \n");
		for (int i = 0; i < listEmpresa.size(); i++) {
			System.out.println("Indice: " + i + ") " + listEmpresa.get(i));
		}

		System.out.println("Selecione a empresa pelo indice:");
		int indice = scanner.nextInt();

		if (indice < listEmpresa.size()) {
			return listEmpresa.get(indice);
		}

		return new NullEmpresa();
	}

	public void listarEmpresa() {
		System.out.println("Listando empresas");

		if (listEmpresa.isEmpty()) {
			new NullEmpresa();
			return;
		}

		for (Empresa empresa : listEmpresa) {
			System.out.println(empresa);
			System.out.println("\n");
		}
	}

	public List<Empresa> getListEmpresa() {
		return listEmpresa;
	}

}
