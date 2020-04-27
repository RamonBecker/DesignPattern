package br.edu.pattertproject.fireman.bridge_pattern;

import br.edu.pattertproject.fireman.bridge_pattern.edificacao.VistoriaHabitese;
import br.edu.pattertproject.fireman.bridge_pattern.edificacao.VistoriaParcial;
import br.edu.pattertproject.fireman.entites.Vistoria;

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
