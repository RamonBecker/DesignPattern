package br.edu.pattertproject.fireman.Fireman.strategy_pattern;

public enum TipoTaxa {
	ANUAL {
		@Override
		public StrategyTaxa obterTipoTaxa() {
			return new TaxaAnual();
		}
	},

	HABITESE {
		@Override
		public StrategyTaxa obterTipoTaxa() {
			return new TaxaHabitese();
		}
	};

	public abstract StrategyTaxa obterTipoTaxa();

}
