package br.edu.pattertproject.fireman.part3.command;

import java.util.Random;

public class AcelerarViatura implements Comando {

	private TrocarMarchaViatura trocarMarchaViatura;

	@Override
	public void executar() {
		Random gerarVelocidade = new Random();
		int velocidade_gerada = gerarVelocidade.nextInt(80);
		TrocarMarchaViatura.velocidadeRecebida = velocidade_gerada;
		trocarMarchaViatura.executar();

	}

	public TrocarMarchaViatura getTrocarMarchaViatura() {
		return trocarMarchaViatura;
	}

	public void setTrocarMarchaViatura(TrocarMarchaViatura trocarMarchaViatura) {
		if (trocarMarchaViatura == null) {
			throw new IllegalArgumentException("Não foi possível trocar a machar, pois o objeto é nulo");
		}
		this.trocarMarchaViatura = trocarMarchaViatura;
	}

}
