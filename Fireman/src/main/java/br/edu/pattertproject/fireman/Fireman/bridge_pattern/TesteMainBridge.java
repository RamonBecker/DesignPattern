package br.edu.pattertproject.fireman.Fireman.bridge_pattern;

import java.util.Scanner;
import br.edu.pattertproject.fireman.Fireman.dao.DaoEmpresa;
import br.edu.pattertproject.fireman.Fireman.dao.DaoVistoria;
import br.edu.pattertproject.fireman.Fireman.entites.Empresa;
import br.edu.pattertproject.fireman.Fireman.entites.Vistoria;
import br.edu.pattertproject.fireman.Fireman.null_objects.NullEmpresa;
import br.edu.pattertproject.fireman.Fireman.null_objects.NullTipoVistoria;

public class TesteMainBridge {

	public static void main(String[] args) {

		try (Scanner scanner = new Scanner(System.in)) {

			DaoEmpresa daoEmpresa = new DaoEmpresa();
			DaoVistoria daoVistoria = new DaoVistoria();
			Vistoria vistoria = null;
			Empresa empresa = null;

			while (true) {

				System.out.println("1) Registrar empresa");
				System.out.println("2) Solicitar vistoria");
				System.out.println("3) Gerar classificação de risco para vistoria:");

				int leitura = scanner.nextInt();

				switch (leitura) {
				case 1:

					daoEmpresa.createEmpresa(scanner);

					break;

				case 2:

					empresa = daoEmpresa.buscarEmpresa(scanner);

					if (!(empresa instanceof NullEmpresa)) {

						vistoria = daoVistoria.tipoVistoriaEscolhido(scanner);

						if (vistoria instanceof NullTipoVistoria) {
							empresa.setVistoria(vistoria);
							daoEmpresa.updateEmpresa(empresa);
						}

					}

					break;

				case 3:

					empresa = daoEmpresa.buscarEmpresa(scanner);

					String retorno = daoVistoria.questionarioFatorRisco(new RiscoElevado(), "Escolha a opção de risco:",
							scanner);

					if (retorno.isEmpty()) {
						retorno = daoVistoria.questionarioFatorRisco(new RiscoLeve(), "Escolha a opção de risco:",
								scanner);
					}

					break;
				}

			}
		}

	}

}
