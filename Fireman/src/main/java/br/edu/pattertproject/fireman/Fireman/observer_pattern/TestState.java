package br.edu.pattertproject.fireman.Fireman.observer_pattern;

import java.util.Scanner;
import br.edu.pattertproject.fireman.Fireman.entites.Pessoa.Endereco;
import br.edu.pattertproject.fireman.Fireman.entites.Pessoa.Usuario;

public class TestState {

	public static void main(String[] args) {

		try (Scanner scanner = new Scanner(System.in)) {
			
			
			
			while (true) {

				System.out.println("1) Criar Ocorrencia");
				System.out.println("2) Criar Viatura");
				System.out.println("3) Acompanhar Ocorrencia");

				int leitura = scanner.nextInt();

				switch (leitura) {
				case 1:

					break;

				case 2:

					break;
					
				case 3:
					break;
				}

			}
		}

//		Endereco endereco = new Endereco("Rua", "Bairro", "Cidade", "0");
//
//		Viatura viatura = new Viatura("ASU", "460");
//		Viatura viatura1 = new Viatura("Caminhão", "00000");
//
//		Usuario usuario = new Usuario("Nome", "Nome Usuario", "4564");
//		
//		
//		
//		Ocorrencia ocorrencia = new Ocorrencia(endereco, viatura1);
//		CentralDeOcorrencia central = new CentralDeOcorrencia(usuario);
//		viatura1.addObserver(central);
//		viatura1.notify("se deslocando para local da ocorrencia");

	}
}
