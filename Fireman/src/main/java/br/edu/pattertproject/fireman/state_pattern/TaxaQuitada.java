package br.edu.pattertproject.fireman.state_pattern;

import br.edu.pattertproject.fireman.entites.Empresa;

public class TaxaQuitada implements InterfaceEstado {

	@Override
	public InterfaceEstado processaPagamento(Empresa empresa) {
		if (empresa.getTaxa() == 0) {
			System.out.println("O pagamento esta quitado");
			System.out.println("A empresa esta liberada para solicitar uma nova vistoria");
			System.out.println(empresa);
			return this;
		}
		return new TaxaPendente().processaPagamento(empresa);
	}

}
