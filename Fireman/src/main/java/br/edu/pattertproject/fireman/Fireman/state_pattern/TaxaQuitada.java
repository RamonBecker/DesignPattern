package br.edu.pattertproject.fireman.Fireman.state_pattern;

import br.edu.pattertproject.fireman.Fireman.entites.Empresa;

public class TaxaQuitada implements InterfaceEstado {

	@Override
	public boolean processaPagamento(Empresa empresa) {
		if (empresa.getTaxa() == 0) {
			return true;
		}
		return false;
	}

}
