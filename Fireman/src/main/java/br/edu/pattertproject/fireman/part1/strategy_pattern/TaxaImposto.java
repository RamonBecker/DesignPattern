package br.edu.pattertproject.fireman.part1.strategy_pattern;

public class TaxaImposto implements StrategyTaxa {

	@Override
	public double calcularTaxa(double valor) {
		
		return valor * 0.7;
	}

}
