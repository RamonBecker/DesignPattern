package br.edu.pattertproject.fireman.Fireman.bridge_pattern;


public class RiscoElevado extends Risco {

	public RiscoElevado() {
		getFatoresRiscos().add("gas: P13, P45 ou canalizado");
		getFatoresRiscos().add("deposito de combustiveis ou liquido inflamavel");
		getFatoresRiscos().add("deposito de explosivos");

	}

	@Override
	public BridgeClassificacaoRisco processaClassificacaoRisco(String riscosRecebido) {
		
		for (int i = 0; i < getFatoresRiscos().size(); i++) {

			if (getFatoresRiscos().get(i).equals(riscosRecebido)) {
				return this;
			}

		}
		return new RiscoLeve().processaClassificacaoRisco(riscosRecebido);

	}

	@Override
	public String toString() {
		return "Risco Elevado";
	}
}
