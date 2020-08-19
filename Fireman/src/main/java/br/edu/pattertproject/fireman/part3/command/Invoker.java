package br.edu.pattertproject.fireman.part3.command;

import br.edu.pattertproject.fireman.part3.fluent_interfaces.Viatura;

public class Invoker {

	private Viatura viatura;

	public void executa_Trocar_Marcha(TrocarMarcha trocarMarchaViatura) {
		if (trocarMarchaViatura == null) {
			throw new IllegalArgumentException("A troca de marcha não pode ser nula");
		}
		trocarMarchaViatura.setMotor(viatura.getMotor());
		viatura.executar_Motor(trocarMarchaViatura);
	}

	public void executa_acelerar(Acelerar acelerar) {
		if (acelerar == null) {
			throw new IllegalArgumentException("O acelerar não pode ser nula");

		}
		viatura.executar_Motor(acelerar);
	}

	public void executa_Freiar(Freiar freiar) {
		if (freiar == null) {
			throw new IllegalArgumentException("O freiar não pode ser nulo");

		}
		freiar.setMotor(viatura.getMotor());
		viatura.executar_Motor(freiar);
	}

	public Viatura getViatura() {
		return viatura;
	}

	public void setViatura(Viatura viatura) {
		if (viatura == null) {
			throw new IllegalArgumentException("A viautura não pode ser vazia");
		}
		this.viatura = viatura;
	}

}
