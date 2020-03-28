package br.edu.pattertproject.fireman.Fireman.bridge_pattern;

import java.util.List;

import br.edu.pattertproject.fireman.Fireman.null_objects.risco.NullRiscoMedio;

public class RiscoMedio extends Risco {

	public RiscoMedio() {

		getFatoresRiscos().add("Comercio varejista");
		getFatoresRiscos().add("comercio de produtos eletronicos");
		getFatoresRiscos().add("Borracharia");
		getFatoresRiscos().add("Mecânica");
	}

	@Override
	public BridgeClassificacaoRisco processaClassificacaoRisco(List<String> riscosRecebidos) {

		// for (int i = 0; i < getFatoresRiscos().size(); i++) {
		// for (int j = 0; j < riscosRecebidos.size(); j++) {
		// if (getFatoresRiscos().get(i).contains(riscosRecebidos.get(j))) {
		return this;
		/// }/
		// }

		// }

		// return new RiscoLeve().processaClassificacaoRisco(riscosRecebidos);
	}

	@Override
	public String toString() {
		return "Risco Medio";
	}

}
