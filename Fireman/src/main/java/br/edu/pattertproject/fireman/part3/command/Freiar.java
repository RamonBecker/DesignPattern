package br.edu.pattertproject.fireman.part3.command;

public class Freiar implements Comando {

	private Motor motor;

	@Override
	public void executar() {

		System.out.println("Freiando");

		motor = Motor.getInstance();
		motor.getVelocidades().forEach((k, v) -> {
			v.clear();
		});

		// System.out.println("lista do motor apos o freio:" + motor.getVelocidades());
	}

}
