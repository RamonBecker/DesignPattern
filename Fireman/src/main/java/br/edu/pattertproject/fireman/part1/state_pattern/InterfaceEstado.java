package br.edu.pattertproject.fireman.part1.state_pattern;

import br.edu.pattertproject.fireman.part1.entites.Empresa;

public interface InterfaceEstado {
	
	public InterfaceEstado processaPagamento(Empresa empresa);

}
