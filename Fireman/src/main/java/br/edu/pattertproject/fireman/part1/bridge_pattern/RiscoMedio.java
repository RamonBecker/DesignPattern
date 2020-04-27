package br.edu.pattertproject.fireman.part1.bridge_pattern;


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
