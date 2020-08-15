package br.edu.pattertproject.fireman.testespatterns.part3;

import br.edu.pattertproject.fireman.part3.command.AcelerarViatura;
import br.edu.pattertproject.fireman.part3.command.TrocarMarchaViatura;
import br.edu.pattertproject.fireman.part3.fluent_interfaces.Viatura;

public class TesteComando {

	public static void main(String[] args) {
		Viatura viatura = new Viatura();
		TrocarMarchaViatura trocarMarchaViatura = new TrocarMarchaViatura();
		AcelerarViatura acelerarViatura = new AcelerarViatura();
		acelerarViatura.setTrocarMarchaViatura(trocarMarchaViatura);
		acelerarViatura.executar();
		// acelerarViatura.executar(viatura);[

	}

}
