package br.edu.pattertproject.fireman.Fireman.strategy_pattern;

public class TaxaAnual implements StrategyTaxa {

	@Override
	public double calcularTaxa(double valor) {
		return valor * 0.5;
	}
}
