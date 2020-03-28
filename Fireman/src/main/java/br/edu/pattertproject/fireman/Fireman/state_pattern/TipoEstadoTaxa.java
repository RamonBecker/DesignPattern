package br.edu.pattertproject.fireman.Fireman.state_pattern;

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
