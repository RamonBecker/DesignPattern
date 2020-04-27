package br.edu.pattertproject.fireman.bridge_pattern;



public class RiscoLeve extends Risco {

	public RiscoLeve() {
		getFatoresRiscos().add("A empresa não possui area edificada");
	}

	@Override
	public BridgeClassificacaoRisco processaClassificacaoRisco(String riscosRecebidos) {
		if (getFatoresRiscos().get(0).equals(riscosRecebidos)) {
			return this;
		}

		return new RiscoMedio().processaClassificacaoRisco(riscosRecebidos);
	}

	@Override
	public String toString() {
		return "Risco Leve";
	}

}
