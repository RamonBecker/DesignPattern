package br.edu.pattertproject.fireman.part1.state_pattern;

public enum TipoEstadoTaxa {
	
	TaxaQuitada {
		@Override
		public InterfaceEstado obterEstadoTaxa() {
			return new TaxaQuitada();
		}
	},
	TaxaPendente {
		@Override
		public InterfaceEstado obterEstadoTaxa() {
			return new TaxaPendente();
		}
	};
	
	public abstract InterfaceEstado obterEstadoTaxa();
	
	
	

}
