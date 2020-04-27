package br.edu.pattertproject.fireman.entites;

import br.edu.pattertproject.fireman.bridge_pattern.BridgeClassificacaoRisco;

public abstract class Vistoria {

	private BridgeClassificacaoRisco bridgeClassificacaoRisco;

	public BridgeClassificacaoRisco getBridgeClassificacaoRisco() {
		return bridgeClassificacaoRisco;
	}

	public void setBridgeClassificacaoRisco(BridgeClassificacaoRisco bridgeClassificacaoRisco) {
		this.bridgeClassificacaoRisco = bridgeClassificacaoRisco;
	}

	public BridgeClassificacaoRisco processaClassificacaoRisco(String riscosRecebidos) {
		return bridgeClassificacaoRisco.processaClassificacaoRisco(riscosRecebidos);
	}

	@Override
	public String toString() {
		return "Vistoria [Classificação de risco:" + bridgeClassificacaoRisco + "]";
	}

}
