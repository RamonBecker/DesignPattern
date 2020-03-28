package br.edu.pattertproject.fireman.Fireman.testespatterns;

import java.util.Scanner;
import br.edu.pattertproject.fireman.Fireman.dao.DaoEmpresa;
import br.edu.pattertproject.fireman.Fireman.entites.Empresa;
import br.edu.pattertproject.fireman.Fireman.null_objects.NullEmpresa;
import br.edu.pattertproject.fireman.Fireman.state_pattern.TipoEstadoTaxa;
import br.edu.pattertproject.fireman.Fireman.strategy_pattern.TipoTaxa;

public class TestStateStrategy {

	public static void main(String[] args) {

		DaoEmpresa daoEmpresa = new DaoEmpresa();
		Empresa empresa = null;

		try (Scanner scanner = new Scanner(System.in)) {
			while (true) {
				
				// Observações:
				// 2 - Usando o strategy para gerar a taxa
				// 3 - Usando state para usar solicitação de serviço, caso a empresa não tenho
				// pago a taxa de serviço
				// Não será possível realzar a solicitação, caso contrário a empresa esta
				// liberada para realizar a solicitação

				int indice;

				System.out.println("1) Registrar empresa");
				System.out.println("2) Mostrar dados da empresa");
				System.out.println("3) Gerar taxa");
				System.out.println("4) Solicitação de serviço");
				System.out.println("5) Pagar taxa");
				System.out.println("6) Encerrar");
				
				int leitura = scanner.nextInt();

				switch (leitura) {

				case 1:
					daoEmpresa.getListEmpresa().add(daoEmpresa.createEmpresa(scanner));
					break;
				case 2:

					daoEmpresa.listarEmpresa();
					break;

				case 3:

					empresa = daoEmpresa.buscarEmpresa(scanner);

					if (!(empresa instanceof NullEmpresa)) {
						indice = daoEmpresa.tipoTaxaEscolhido(scanner, TipoTaxa.values(), "Gerando taxa com Strategy");
						empresa.setStrategyTaxa(TipoTaxa.values()[indice].obterTipoTaxa());
						empresa.gerarTaxa(100);
					}

					break;

				case 4:
					empresa = daoEmpresa.buscarEmpresa(scanner);

					if (!(empresa instanceof NullEmpresa)) {

						indice = daoEmpresa.tipoTaxaEscolhido(scanner, TipoEstadoTaxa.values(),
								"Verificando estado de pagamento com State");
						empresa.setInterfaceEstado(TipoEstadoTaxa.values()[indice].obterEstadoTaxa());
						empresa.solicitarVistoria();
					}

					break;

				case 5:

					empresa = daoEmpresa.buscarEmpresa(scanner);

					if (!(empresa instanceof NullEmpresa)) {
						daoEmpresa.pagarTaxa(empresa);
					}

					break;
				}
			}

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}

}
