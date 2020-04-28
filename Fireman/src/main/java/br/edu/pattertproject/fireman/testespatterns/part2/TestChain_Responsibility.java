package br.edu.pattertproject.fireman.testespatterns.part2;

import java.util.Scanner;
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

		try (Scanner scanner = new Scanner(System.in)) {
			while (true) {
				System.out.println("Digite as opções para escolher:");
				System.out.println("1) Cadastrar empresa");
				System.out.println("2) Gerar ocorrência");
				System.out.println("3) Buscar empresa");
				System.out.println("4) Buscar ocorrência");
				System.out.println("5) Listar dados");

				int key = scanner.nextInt();

				switch (key) {

				case 1:

					Empresa empresa = addEmpresa(scanner);

					selectedBanco(scanner, empresa);

					break;
				case 2:
					
					break;

				case 5:
					System.out.println(banco.getListsEmpresas());

				}

			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static <T> void selectedBanco(Scanner scanner, T dado) {

		System.out.println("Escolha os bancos que deseja inserir os dados");
		System.out.println("1) Cache");
		System.out.println("2) MYSQL");
		System.out.println("3) PostGreSQL");

		int opBD = scanner.nextInt();

		if (opBD == 1) {
			addObject(CacheMemory.getInstance(), dado);
		}

		else if (opBD == 2) {
			addObject(BancoMysql.getInstance(), dado);
		}

		else if (opBD == 3) {
			addObject(BancoPostGreSQL.getInstance(), dado);
		}
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

	private static <T> void addObject(RecuperarDado recuperarDado, T dado) {
		banco = recuperarDado;

		if (banco instanceof CacheMemory) {

			CacheMemory cacheMemory = (CacheMemory) banco;

			if (dado instanceof Empresa) {
				Empresa empresa = (Empresa) dado;
				cacheMemory.add(empresa.getDocumento().getNumeroDocumento(), empresa, cacheMemory.getListsEmpresas());
			}

		}

		else if (banco instanceof BancoPostGreSQL) {
			BancoPostGreSQL bancoPostGreSQL = (BancoPostGreSQL) banco;

			if (dado instanceof Empresa) {
				Empresa empresa = (Empresa) dado;
				bancoPostGreSQL.add(empresa.getDocumento().getNumeroDocumento(), empresa,
						bancoPostGreSQL.getListsEmpresas());
			}

		}

		else if (banco instanceof BancoMysql) {
			BancoMysql bancoMysql = (BancoMysql) banco;

			if (dado instanceof Empresa) {
				Empresa empresa = (Empresa) dado;

				bancoMysql.add(empresa.getDocumento().getNumeroDocumento(), empresa, bancoMysql.getListsEmpresas());
			}
		}
	}
}
