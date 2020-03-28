package br.edu.pattertproject.fireman.Fireman.state_pattern;

import br.edu.pattertproject.fireman.Fireman.entites.Empresa;

public interface InterfaceEstado {
	
	public InterfaceEstado processaPagamento(Empresa empresa);

}
