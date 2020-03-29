package br.edu.pattertproject.fireman.Fireman.observer_pattern;

import java.util.Scanner;

import br.edu.pattertproject.fireman.Fireman.dao.DaoOcorrencia;

public class TestState {

	public static void main(String[] args) {

		try (Scanner scanner = new Scanner(System.in)) {

			DaoOcorrencia daoOcorrencia = new DaoOcorrencia();

			while (true) {

				System.out.println("1) Criar Ocorrencia");
				System.out.println("2) Criar Viatura");
				System.out.println("3) Acompanhar Ocorrencia");
				System.out.println("4) Sair");

				int leitura = scanner.nextInt();

				switch (leitura) {
				case 1:

					daoOcorrencia.gerarOcorrencia(scanner);

					break;

				case 2:

					daoOcorrencia.criarViatura(scanner);

					break;

				case 3:

					daoOcorrencia.acompanharOcorrencia(scanner);

					break;
				}

				if (leitura == 4) {
					break;
				}

			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}
}
