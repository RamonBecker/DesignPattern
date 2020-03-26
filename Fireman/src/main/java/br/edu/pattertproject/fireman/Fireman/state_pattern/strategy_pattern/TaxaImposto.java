package br.edu.pattertproject.fireman.Fireman.state_pattern.strategy_pattern;

public class TaxaImposto implements StrategyTaxa {

	@Override
	public double calcularTaxa(double valor) {
		return valor * 0.71;
	}

}
