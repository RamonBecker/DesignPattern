package br.edu.pattertproject.fireman.Fireman.bridge_pattern;

import br.edu.pattertproject.fireman.Fireman.bridge_pattern.edificacao.VistoriaHabitese;
import br.edu.pattertproject.fireman.Fireman.bridge_pattern.edificacao.VistoriaParcial;
import br.edu.pattertproject.fireman.Fireman.entites.Vistoria;

public enum TipoVistoria {
	Vistoria_Parcialmente {
		@Override
		public Vistoria obterTipoVistoria() {
			return new VistoriaParcial();
		}
	},
	Vistoria_Habitese {
		@Override
		public Vistoria obterTipoVistoria() {
			return new VistoriaHabitese();
		}
	};

	public abstract Vistoria obterTipoVistoria();
}
