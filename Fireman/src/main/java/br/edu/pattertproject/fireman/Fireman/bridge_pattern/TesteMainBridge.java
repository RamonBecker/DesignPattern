package br.edu.pattertproject.fireman.Fireman.bridge_pattern;

import java.util.Scanner;

import br.edu.pattertproject.fireman.Fireman.bridge_pattern.edificacao.VistoriaHabitese;
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
				System.out.println("4) Listar vistorias parcial e habitese");
				System.out.print("Selecione a opção:");

				int leitura = scanner.nextInt();

				switch (leitura) {
				case 1:

					empresa = daoEmpresa.createEmpresa(scanner);

					daoEmpresa.getListEmpresa().add(empresa);

					break;

				case 2:

					empresa = daoEmpresa.buscarEmpresa(scanner);

					if (!(empresa instanceof NullEmpresa)) {

						vistoria = daoVistoria.tipoVistoriaEscolhido(scanner, "Tipo de vistoria a ser realizado:");

						if (!(vistoria instanceof NullTipoVistoria)) {

							if (vistoria instanceof VistoriaHabitese) {
								daoVistoria.createEdificacao(scanner, empresa, vistoria);
							}

							empresa.setVistoria(vistoria);
							daoEmpresa.updateEmpresa(empresa);
						}

					}

					break;

				case 3:

					daoVistoria.gerarClassificacao(scanner, daoEmpresa);

					break;

				case 4:

					daoVistoria.listarEdificacoes();
					
					break;

				}

				if (leitura == 5) {
					break;
				}

			}
		}

	}

}
