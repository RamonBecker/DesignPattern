package br.edu.pattertproject.fireman.testespatterns.part2;

import java.util.Map;
import java.util.Scanner;
import br.edu.pattertproject.fireman.exception.ErrorAddEmpresa;
import br.edu.pattertproject.fireman.exception.ErrorBuscarEmpresa;
import br.edu.pattertproject.fireman.exception.ErrorRemoverEmpresa;
import br.edu.pattertproject.fireman.exception.ErrorSelectedBanco;
import br.edu.pattertproject.fireman.part1.entites.Empresa;
import br.edu.pattertproject.fireman.part1.entites.documents.DocumentoCNPJ;
import br.edu.pattertproject.fireman.part2.chan_responsibility_pattern.BancoMysql;
import br.edu.pattertproject.fireman.part2.chan_responsibility_pattern.BancoPostGreSQL;
import br.edu.pattertproject.fireman.part2.chan_responsibility_pattern.CacheMemory;
import br.edu.pattertproject.fireman.part2.proxy_decorator_pattern.EmpresaDaoDecorator;
import br.edu.pattertproject.fireman.part2.proxy_decorator_pattern.InterfaceDao;

public class Test_Decorator_Proxy {

	private static InterfaceDao proxy = EmpresaDaoDecorator.getInstance();

	public static void main(String[] args) {

		

		try (Scanner scanner = new Scanner(System.in)){

			while (true) {

				System.out.println("1) Adicionar empresa");
				System.out.println("2) Buscar Empresa");
				System.out.println("3) Remover Empresa");
				System.out.println("4) Listar dados");
				System.out.print("Digite as opções para escolher:");

				int op = scanner.nextInt();

				switch (op) {
				case 1:

					proxy.setInterfaceDao(selecionarBanco(scanner));
					addEmpresa(scanner);

					break;

				case 2:

					proxy.setInterfaceDao(selecionarBanco(scanner));
					System.out.println("Empresa buscada:" + buscarEmpresa(scanner));

					break;
				case 3:

					proxy.setInterfaceDao(selecionarBanco(scanner));
					System.out.println("Objeto removido:" + removerEmpresa(scanner));

					break;
				}
			}
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}

	}

	private static Object removerEmpresa(Scanner scanner) throws ErrorRemoverEmpresa {
		String cnpj;
		System.out.println("Digite o CNPJ para buscar a empresa:");
		cnpj = scanner.next().trim();

		return proxy.remover(cnpj, new Empresa());
	}

	private static Object buscarEmpresa(Scanner scanner) throws ErrorBuscarEmpresa {
		String cnpj;
		System.out.println("Digite o CNPJ para buscar a empresa:");
		cnpj = scanner.next().trim();

		return proxy.buscar(cnpj, new Empresa());

	}

	private static void addEmpresa(Scanner scanner) throws ErrorAddEmpresa {
		String cnpj, nomeFantasia, razaoSocial, ocupacao;

		System.out.print("Digite o cnpj:");
		cnpj = scanner.next().trim();

		System.out.print("Digite o nome fantasia:");
		nomeFantasia = scanner.next().trim();

		System.out.print("Digite a razao social:");
		razaoSocial = scanner.next().trim();

		System.out.print("Digite a ocupação da empresa: ");
		ocupacao = scanner.next().trim();

		Empresa empresa = new Empresa(new DocumentoCNPJ(cnpj), nomeFantasia, razaoSocial, ocupacao);

		proxy.add(empresa.getDocumento().getNumeroDocumento(), empresa);
	}
	
	
	private static <K, V> void selecionarBancoParalistarDados(Scanner scanner) throws ErrorSelectedBanco {
		
		Object object = selecionarBanco(scanner);
		
		if(object instanceof BancoMysql) {
			
		}
	}
	

	
	private static InterfaceDao selecionarBanco(Scanner scanner) throws ErrorSelectedBanco {

		System.out.println("Selecione o banco para o proxy");
		System.out.println("1) Banco MYSQL");
		System.out.println("2) Banco POSTGRESQL");
		System.out.println("3) CacheMemory");
		System.out.print("Digite as opções:");

		int op = scanner.nextInt();

		if (op == 1) {
			return BancoMysql.getInstance();
		}

		else if (op == 2) {
			return BancoPostGreSQL.getInstance();
		}

		else if (op == 3) {
			return CacheMemory.getInstance();
		}
		
		throw new ErrorSelectedBanco("Erro ao selecionar o banco");
	}
}
