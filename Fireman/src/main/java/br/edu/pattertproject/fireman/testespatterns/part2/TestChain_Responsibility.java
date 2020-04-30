package br.edu.pattertproject.fireman.testespatterns.part2;

import java.util.Map;
import java.util.Scanner;
import br.edu.pattertproject.fireman.exception.ErrorSearchDado;
import br.edu.pattertproject.fireman.part1.entites.Empresa;
import br.edu.pattertproject.fireman.part1.entites.documents.DocumentoCNPJ;
import br.edu.pattertproject.fireman.part1.entites.person.Endereco;
import br.edu.pattertproject.fireman.part1.observer_pattern.Ocorrencia;
import br.edu.pattertproject.fireman.part1.observer_pattern.Viatura;
import br.edu.pattertproject.fireman.part2.chan_responsibility_pattern.BancoMysql;
import br.edu.pattertproject.fireman.part2.chan_responsibility_pattern.BancoPostGreSQL;
import br.edu.pattertproject.fireman.part2.chan_responsibility_pattern.CacheMemory;
import br.edu.pattertproject.fireman.part2.chan_responsibility_pattern.RecuperarDado;

public class TestChain_Responsibility {
	private static RecuperarDado banco = null;
	public static void main(String[] args) {

		CacheMemory.getInstance().setRecuperador(BancoPostGreSQL.getInstance());
		BancoPostGreSQL.getInstance().setRecuperador(BancoMysql.getInstance());
		BancoMysql.getInstance().setRecuperador(null);

		try (Scanner scanner = new Scanner(System.in)) {
			while (true) {
			
				System.out.println("1) Cadastrar empresa");
				System.out.println("2) Gerar ocorrência");
				System.out.println("3) Buscar empresa");
				System.out.println("4) Buscar ocorrência");
				System.out.println("5) Listar dados");
				System.out.print("Digite as opções para escolher:");
				int key = scanner.nextInt();

				switch (key) {

				case 1:

					Empresa empresa = addEmpresa(scanner);

					banco = selectedBanco(scanner);

					addObjectBanco(banco, empresa);
					break;
				case 2:

					Viatura viatura = addOcorrencia(scanner);

					banco = selectedBanco(scanner);

					addObjectBanco(banco, viatura);

					break;

				case 3:

					buscarDado(scanner, "Empresa");
					break;

				case 4:
					buscarDado(scanner, "Ocorrência");
					break;

				case 5:

					banco = selectedBanco(scanner);
					listarDados(banco.getListsEmpresas());
					listarDados(banco.getListsViaturas());

				}

			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static <K, V> void listarDados(Map<K, V> map) {
		System.out.println("Listando dados");
		for (V value : map.values()) {
			System.out.println(value);
		}
	}

	private static RecuperarDado selectedBanco(Scanner scanner) {

		System.out.println("Escolha o banco");
		System.out.println("1) Cache");
		System.out.println("2) MYSQL");
		System.out.println("3) PostGreSQL");
		System.out.print("Digite a opção:");

		int opBD = scanner.nextInt();

		RecuperarDado banco = null;

		if (opBD == 1) {
			banco = CacheMemory.getInstance();
		}

		else if (opBD == 2) {
			banco = BancoMysql.getInstance();
		}

		else if (opBD == 3) {
			banco = BancoPostGreSQL.getInstance();
		}

		return banco;
	}

	private static Viatura addOcorrencia(Scanner scanner) {

		String rua, bairro, cidade, numero, nomeViatura, modeloViatura;

		System.out.print("Digite a rua:");
		rua = scanner.next().trim();

		System.out.print("Digite o bairro:");
		bairro = scanner.next().trim();

		System.out.print("Digite a cidade:");
		cidade = scanner.next().trim();

		System.out.print("Digite o numero:");
		numero = scanner.next().trim();

		Endereco endereco = new Endereco(rua, bairro, cidade, numero);

		Ocorrencia ocorrencia = new Ocorrencia(endereco);

		System.out.print("Digite o nome da viatura:");
		nomeViatura = scanner.next().trim();

		System.out.print("Digite o modelo da viatura:");
		modeloViatura = scanner.next().trim();

		Viatura viatura = new Viatura(nomeViatura, modeloViatura);
		viatura.setOcorrencia(ocorrencia);

		return viatura;
	}

	private static Empresa addEmpresa(Scanner scanner) {
		String cnpj, nomeFantasia, razaoSocial, ocupacao;

		System.out.print("Digite o cnpj:");
		cnpj = scanner.next().trim();

		System.out.print("Digite o nome fantasia:");
		nomeFantasia = scanner.next().trim();

		System.out.print("Digite a razao social:");
		razaoSocial = scanner.next().trim();

		System.out.print("Digite a ocupação da empresa: ");
		ocupacao = scanner.next().trim();

		return new Empresa(new DocumentoCNPJ(cnpj), nomeFantasia, razaoSocial, ocupacao);

	}

	private static <T> void addObjectBanco(RecuperarDado recuperarDado, T dado) {
		banco = recuperarDado;

		if (banco instanceof CacheMemory) {

			CacheMemory cacheMemory = (CacheMemory) banco;

			if (dado instanceof Empresa) {
				Empresa empresa = (Empresa) dado;
				cacheMemory.add(empresa.getDocumento().getNumeroDocumento(), empresa);
			}

			if (dado instanceof Viatura) {
				Viatura viatura = (Viatura) dado;
				cacheMemory.add(viatura.getModelo(), viatura);
			}

		}

		else if (banco instanceof BancoPostGreSQL) {
			BancoPostGreSQL bancoPostGreSQL = (BancoPostGreSQL) banco;

			if (dado instanceof Empresa) {
				Empresa empresa = (Empresa) dado;
				bancoPostGreSQL.add(empresa.getDocumento().getNumeroDocumento(), empresa);
			}
			if (dado instanceof Viatura) {
				Viatura viatura = (Viatura) dado;
				bancoPostGreSQL.add(viatura.getModelo(), viatura);
			}

		}

		else if (banco instanceof BancoMysql) {
			BancoMysql bancoMysql = (BancoMysql) banco;

			if (dado instanceof Empresa) {
				Empresa empresa = (Empresa) dado;
				bancoMysql.add(empresa.getDocumento().getNumeroDocumento(), empresa);
			}
		}
	}

	private static void buscarDado(Scanner scanner, String type) {

		System.out.println("--------- Buscar dado ---------");

		try {
			String dado = null;
			if (type.contentEquals("Empresa")) {
				System.out.print("Digite o cnpj para buscar o dado:");
				dado = scanner.next().trim();
			}

			if (type.contentEquals("Ocorrência")) {
				System.out.println("Digite o modelo da viatura para buscar o dado:");
				dado = scanner.next().trim();
			}

			RecuperarDado banco = CacheMemory.getInstance();
			System.out.println("Dado buscado: " + banco.buscarDado(dado));

		} catch (ErrorSearchDado e) {
			System.err.println(e.getMessage());
		}
	}

}
