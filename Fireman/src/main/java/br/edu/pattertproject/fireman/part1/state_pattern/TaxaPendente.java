package br.edu.pattertproject.fireman.part1.state_pattern;

import br.edu.pattertproject.fireman.part1.entites.Empresa;

public class TaxaPendente implements InterfaceEstado {

	@Override
	public InterfaceEstado processaPagamento(Empresa empresa) {
		if (empresa.getTaxa() > 0) {
			System.out.println("A empresa não pode solicitar nova vistoria, pois esta com pendencia em pagamento:"
					+ empresa.getTaxa() + " reais");

			return this;
		}

		return new TaxaQuitada().processaPagamento(empresa);
	}

}
