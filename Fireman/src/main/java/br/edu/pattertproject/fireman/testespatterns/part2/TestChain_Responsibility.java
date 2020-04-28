package br.edu.pattertproject.fireman.testespatterns.part2;

import java.util.Scanner;

import br.edu.pattertproject.fireman.exception.ErrorSearchDado;
import br.edu.pattertproject.fireman.part1.entites.Empresa;
import br.edu.pattertproject.fireman.part1.entites.documents.DocumentoCNPJ;
import br.edu.pattertproject.fireman.part2.chan_responsibility_pattern.BancoMysql;
import br.edu.pattertproject.fireman.part2.chan_responsibility_pattern.BancoPostGreSQL;
import br.edu.pattertproject.fireman.part2.chan_responsibility_pattern.CacheMemory;
import br.edu.pattertproject.fireman.part2.chan_responsibility_pattern.RecuperarDado;

public class TestChain_Responsibility {

	public static void main(String[] args) {

		BancoPostGreSQL bancoPostGreSQL = null;
		BancoMysql bancoMysql = null;
		CacheMemory cacheMemory = null;

		try (Scanner scanner = new Scanner(System.in)) {
			while (true) {
				System.out.println("Digite as opções para escolher:");
				System.out.println("1) Cadastrar empresa");
				System.out.println("2) Gerar ocorrência");
				System.out.println("3) Buscar empresa");
				System.out.println("4) Buscar ocorrência");

				int key = scanner.nextInt();

				switch (key) {
				case 1:

					Empresa empresa = addEmpresa(scanner);

					System.out.println("Escolha os bancos que deseja inserir os dados");
					System.out.println("1) Cache");
					System.out.println("2) MYSQL");
					System.out.println("3) PostGreSQL");

					int opBD = scanner.nextInt();

					if (opBD == 1) {
						cacheMemory = new CacheMemory();

						cacheMemory.add((Object)key, empresa, cacheMemory.getListsEmpresas());
					}

					else if (opBD == 2) {

					}

					else if (opBD == 3) {

					}

					break;

				}

			}

			// Empresa empresa = new Empresa(new DocumentoCNPJ("07864837000128"), "Nome
			// fantasia", "Razao Social",
			// "Ocupacional");

			// RecuperarDado recuperarDado = new CacheMemory();
			// recuperarDado.getListsEmpresas().put(empresa.getDocumento().getNumeroDocumento(),
			// empresa);

			// Empresa ep = (Empresa) recuperarDado.buscarDado("07864837000128",
			// recuperarDado.getListsEmpresas());
			// System.out.println(ep);
		} catch (Exception e) {
			e.printStackTrace();
		}
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
}
