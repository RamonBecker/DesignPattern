package br.edu.pattertproject.fireman.part3.command;

import java.util.Random;

public class AcelerarViatura implements Comando {

	private TrocarMarchaViatura trocarMarchaViatura;

	@Override
	public void executar() {
		Random gerarVelocidade = new Random();
		Integer valor_para_gerar_velocidade = 160;

		Integer velocidade_gerada = gerarVelocidade.nextInt(valor_para_gerar_velocidade);
		if (velocidade_gerada == 0) {
			velocidade_gerada = 1;
		}
		System.out.println("valor gerado:" + velocidade_gerada);
		TrocarMarchaViatura.velocidadeRecebida = velocidade_gerada;
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
