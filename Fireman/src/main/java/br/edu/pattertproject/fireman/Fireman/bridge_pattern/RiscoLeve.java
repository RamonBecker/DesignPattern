package br.edu.pattertproject.fireman.Fireman.bridge_pattern;

import java.util.List;

import br.edu.pattertproject.fireman.Fireman.null_objects.risco.NullRiscoLeve;

public class RiscoLeve extends Risco {

	public RiscoLeve() {
		getFatoresRiscos().add("A empresa não possui area edificada");
	}

	@Override
	public BridgeClassificacaoRisco processaClassificacaoRisco(List<String> riscosRecebidos) {
		if (getFatoresRiscos().get(0).contains(riscosRecebidos.get(0))) {
			return this;
		}

		return new NullRiscoLeve();
	}

	@Override
	public String toString() {
		return "Risco Leve";
	}

}
