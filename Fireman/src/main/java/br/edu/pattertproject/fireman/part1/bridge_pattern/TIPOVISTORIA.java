package br.edu.pattertproject.fireman.part1.bridge_pattern;

import br.edu.pattertproject.fireman.part1.entites.Vistoria;

public enum TIPOVISTORIA {
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
