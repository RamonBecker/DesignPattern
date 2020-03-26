package br.edu.pattertproject.fireman.Fireman.observer_pattern;

import br.edu.pattertproject.fireman.Fireman.entites.Pessoa.Endereco;
import br.edu.pattertproject.fireman.Fireman.entites.Pessoa.Usuario;

public class Teste {

	public static void main(String[] args) {
		Endereco endereco = new Endereco("Rua", "Bairro", "Cidade", "0");

		Viatura viatura = new Viatura("ASU", "460");
		Viatura viatura1 = new Viatura("Caminhão", "00000");

		Usuario usuario = new Usuario("Nome", "Nome Usuario", "4564");
		
		
		
		Ocorrencia ocorrencia = new Ocorrencia(endereco, viatura1);
		CentralDeOcorrencia central = new CentralDeOcorrencia(usuario);
		viatura1.addObserver(central);
		viatura1.notify("se deslocando para local da ocorrencia");
				
	}
}
