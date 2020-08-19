package br.edu.pattertproject.fireman.part3.command;

import java.util.Random;

public class Acelerar implements Comando {

	@Override
	public void executar() {
		System.out.println("Acelerando");
		Random gerarVelocidade = new Random();
		Integer valor_para_gerar_velocidade = 160;

		Integer velocidade_gerada = gerarVelocidade.nextInt(valor_para_gerar_velocidade);
		if (velocidade_gerada == 0) {
			velocidade_gerada = 1;
		}
		TrocarMarcha.velocidadeRecebida = velocidade_gerada;
	}

}
