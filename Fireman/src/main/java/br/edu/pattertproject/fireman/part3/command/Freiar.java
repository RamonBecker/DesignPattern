package br.edu.pattertproject.fireman.part3.command;

public class Freiar implements Comando {

	private Motor motor;

	@Override
	public void executar() {

		System.out.println("Freiando");
		System.out.println("--------");
		
		for (int i = motor.getVelocidades().size(); i > 0; i--) {
			System.out.println("Reduzindo velocidade");
			System.out.println("Marcha:"+i+" velocidade:"+motor.getVelocidades().get(i));
			motor.getVelocidades().get(i).clear();
			System.out.println("----------");
			System.out.println("Marcha:"+i+" velocidade:"+motor.getVelocidades().get(i));
			System.out.println("----------");
		}
		System.out.println("----------");
		System.out.println("Map de velocidade após freiar");
		motor.getVelocidades().forEach((k,v) -> {
			System.out.println("Marcha:"+k+" velocidade"+v);
		});
	}

	public Motor getMotor() {
		return motor;
	}

	public void setMotor(Motor motor) {
		if (motor == null) {
			throw new IllegalArgumentException("O motor não pode ser nulo");
		}
		this.motor = motor;
	}

}
