package br.edu.pattertproject.fireman.testespatterns.part3;

import br.edu.pattertproject.fireman.part3.command.AcelerarViatura;
import br.edu.pattertproject.fireman.part3.command.Freiar;
import br.edu.pattertproject.fireman.part3.command.Motor;
import br.edu.pattertproject.fireman.part3.command.TrocarMarchaViatura;

public class TesteComando {
	static int cont = 0;

	public static void main(String[] args) {
		TrocarMarchaViatura trocarMarchaViatura = new TrocarMarchaViatura();
		AcelerarViatura acelerarViatura = new AcelerarViatura();
		acelerarViatura.setTrocarMarchaViatura(trocarMarchaViatura);
		Freiar freiar = new Freiar();
		Motor motor = new Motor();
		System.out.println("Primerio teste ----------------");
		// 1
		System.out.println("Acelerando");

		acelerarViatura.executar();
		System.out.println("trocando de marcha");

		trocarMarchaViatura.setMotor(motor);
		trocarMarchaViatura.executar();
		System.out.println("freiando");
		freiar.executar();
		// 2
		

		System.out.println("segundo teste ----------------");
//
		System.out.println("Acelerando");
		acelerarViatura.executar();
		System.out.println("trocando de marcha");

		trocarMarchaViatura.setMotor(motor);
		trocarMarchaViatura.executar();
		System.out.println("freiando");
		freiar.executar();

	}

}
