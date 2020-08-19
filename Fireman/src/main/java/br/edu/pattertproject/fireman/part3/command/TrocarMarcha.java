package br.edu.pattertproject.fireman.part3.command;

import java.util.ArrayList;
import java.util.List;


public class TrocarMarcha implements Comando {

	public static Integer velocidadeRecebida;
	private Motor motor;
	private int incrementado_proxima_marcha;
	private List<Integer> velocidadesMarcha = new ArrayList<Integer>();
	private int verificarListasVazias = 0;
	private int contMarcha = 0;

	@Override
	public void executar() {

		motor.getVelocidades().forEach((k, v) -> {
			if (v.isEmpty()) {
				verificarListasVazias++;
			}
		});

		if (verificarListasVazias == 5) {

			for (Integer key : motor.getVelocidadesLimite().keySet()) {
				double velocidade = motor.getVelocidadesLimite().get(key);
				if (velocidadeRecebida > velocidade) {
					contMarcha++;
				}
			}

			motor.setMarchaAtual(contMarcha + 1);
			Integer calcDivisao = (int) (velocidadeRecebida / motor.getMarchaAtual());

			Integer aux_calc = 0;

			for (int i = 0; i < motor.getMarchaAtual(); i++) {
				aux_calc += calcDivisao;
				velocidadesMarcha.add(aux_calc);
			}

			for (int i = 0; i < velocidadesMarcha.size(); i++) {
				if (velocidadesMarcha.get(i) <= 5.0) {
					addVelocidadeMotor(1, i);
				}
			}

			if (motor.getVelocidades().containsKey(1)) {
				List<Integer> recuperar = motor.getVelocidades().get(1);
				if (recuperar.isEmpty()) {
					recuperar.add(0);
					motor.getVelocidades().put(1, recuperar);
				}
			}

			incrementado_proxima_marcha = 1;
			double velocidadeLimite = 0;
			int controle_de_Marcha = 1;

			boolean verificando_velocidade_limite = false;
			for (int i = 0; i < velocidadesMarcha.size(); i++) {
				velocidadeLimite = motor.getVelocidadesLimite().get(controle_de_Marcha);
				if (velocidadesMarcha.get(i) > velocidadeLimite) {
					incrementado_proxima_marcha++;
					addVelocidadeMotor(incrementado_proxima_marcha, i);

				} else if (velocidadesMarcha.get(i) <= velocidadeLimite) {

					controle_de_Marcha--;

					if (motor.getVelocidadesLimite().containsKey(controle_de_Marcha)) {
						velocidadeLimite = motor.getVelocidadesLimite().get(controle_de_Marcha);
						if (velocidadesMarcha.get(i) > velocidadeLimite) {
							controle_de_Marcha++;
							verificando_velocidade_limite = true;
							velocidadeLimite = motor.getVelocidadesLimite().get(controle_de_Marcha);
							if (velocidadeLimite < velocidadesMarcha.get(i)) {
								incrementado_proxima_marcha++;
							}
							addVelocidadeMotor(incrementado_proxima_marcha, i);
						}

					}
					if (verificando_velocidade_limite) {
						controle_de_Marcha--;
						verificando_velocidade_limite = false;
					}
				}
				controle_de_Marcha++;
			}
			verificarListasVazias = 0;
			velocidadesMarcha.clear();
		}
		
		
		System.out.println("------------");
		motor.getVelocidades().forEach((k, v) -> {
			System.out.println("Marcha:"+k+" Velocidade: "+v);
		});

	}

	private void addVelocidadeMotor(Integer marchaAtual, int posicao) {

		List<Integer> list = motor.getVelocidades().get(marchaAtual);
		list.add(velocidadesMarcha.get(posicao));
		motor.getVelocidades().put(marchaAtual, list);
	}



	public int getMarchaAtual() {
		return incrementado_proxima_marcha;
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
