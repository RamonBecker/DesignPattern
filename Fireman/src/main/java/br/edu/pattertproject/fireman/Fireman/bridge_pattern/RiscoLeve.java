package br.edu.pattertproject.fireman.Fireman.bridge_pattern;



public class RiscoLeve extends Risco {

	public RiscoLeve() {
		getFatoresRiscos().add("A empresa não possui area edificada");
	}

	@Override
	public BridgeClassificacaoRisco processaClassificacaoRisco(String riscosRecebidos) {
		if (getFatoresRiscos().get(0).contains(riscosRecebidos)) {
			return this;
		}

		return new RiscoMedio().processaClassificacaoRisco(null);
	}

	@Override
	public String toString() {
		return "Risco Leve";
	}

}
