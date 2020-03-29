package br.edu.pattertproject.fireman.Fireman.entites;


import br.edu.pattertproject.fireman.Fireman.bridge_pattern.BridgeClassificacaoRisco;

public abstract class Vistoria {
	
	private BridgeClassificacaoRisco bridgeClassificacaoRisco;
	private BridgeClassificacaoRisco bridgeClassificacaoRisco2;

	public BridgeClassificacaoRisco getBridgeClassificacaoRisco() {
		return bridgeClassificacaoRisco;
	}

	public void setBridgeClassificacaoRisco(BridgeClassificacaoRisco bridgeClassificacaoRisco) {
		this.bridgeClassificacaoRisco = bridgeClassificacaoRisco;
	}

	public BridgeClassificacaoRisco processaClassificacaoRisco(String riscosRecebidos) {
		bridgeClassificacaoRisco2 = bridgeClassificacaoRisco.processaClassificacaoRisco(riscosRecebidos);
		return bridgeClassificacaoRisco.processaClassificacaoRisco(riscosRecebidos);
	}

	
	
	public BridgeClassificacaoRisco getBridgeClassificacaoRisco2() {
		return bridgeClassificacaoRisco2;
	}

	@Override
	public String toString() {
		return "Vistoria [Classificação de risco:" + bridgeClassificacaoRisco + "]";
	}
	

}
