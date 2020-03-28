package br.edu.pattertproject.fireman.Fireman.bridge_pattern;

import java.util.List;

import br.edu.pattertproject.fireman.Fireman.null_objects.risco.NullRiscoElevado;

public class RiscoElevado extends Risco {

	public RiscoElevado() {
		getFatoresRiscos().add("gas: P13, P45 ou canalizado");
		getFatoresRiscos().add("deposito de combustiveis ou liquido inflamavel");
		getFatoresRiscos().add("deposito de explosivos");

	}

	@Override
	public BridgeClassificacaoRisco processaClassificacaoRisco(List<String> riscosRecebido) {
		for (int i = 0; i < getFatoresRiscos().size(); i++) {
			for (int j = 0; j < riscosRecebido.size(); j++) {
				if (getFatoresRiscos().get(i).contains(riscosRecebido.get(j))) {
					return this;
				}
			}
		}
		return new RiscoLeve().processaClassificacaoRisco(riscosRecebido);

	}

	@Override
	public String toString() {
		return "Risco Elevado";
	}
}
