package br.edu.pattertproject.fireman.bridge_pattern;


public class RiscoMedio extends Risco {

	public RiscoMedio() {
	}

	@Override
	public BridgeClassificacaoRisco processaClassificacaoRisco(String riscosRecebidos) {
		return this;
	}

	@Override
	public String toString() {
		return "Risco Medio";
	}

}
