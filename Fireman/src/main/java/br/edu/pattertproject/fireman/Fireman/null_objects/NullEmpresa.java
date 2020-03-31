package br.edu.pattertproject.fireman.Fireman.null_objects;

import br.edu.pattertproject.fireman.Fireman.entites.Empresa;
import br.edu.pattertproject.fireman.Fireman.entites.Vistoria;
import br.edu.pattertproject.fireman.Fireman.state_pattern.InterfaceEstado;
import br.edu.pattertproject.fireman.Fireman.strategy_pattern.StrategyTaxa;

public class NullEmpresa extends Empresa {

	public NullEmpresa() {
	}

	public StrategyTaxa getStrategyTaxa() {
		return null;
	}

	public InterfaceEstado getInterfaceEstado() {
		return null;
	}

	public double getTaxa() {
		return 0;
	}

	public Vistoria getVistoria() {
		return null;
	}

	public String getOcupacao() {
		return null;
	}

	public InterfaceEstado getEstadoPagamento() {
		return null;
	}

	@Override
	public String toString() {
		return "Null Empresa [getStrategyTaxa()=" + getStrategyTaxa() + ", getInterfaceEstado()=" + getInterfaceEstado()
				+ ", getTaxa()=" + getTaxa() + ", getVistoria()=" + getVistoria() + ", getOcupacao()=" + getOcupacao()
				+ ", getEstadoPagamento()=" + getEstadoPagamento() + "]";
	}

}
