package br.edu.pattertproject.fireman.state_pattern;

import br.edu.pattertproject.fireman.entites.Empresa;

public interface InterfaceEstado {
	
	public InterfaceEstado processaPagamento(Empresa empresa);

}
