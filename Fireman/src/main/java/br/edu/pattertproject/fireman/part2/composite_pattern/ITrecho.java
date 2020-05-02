package br.edu.pattertproject.fireman.part2.composite_pattern;

import br.edu.pattertproject.fireman.part1.entites.person.Endereco;
import br.edu.pattertproject.fireman.part1.observer_pattern.Viatura;

public interface ITrecho {

	public Endereco getOrigem();

	public Endereco getDestino();

	public double getDistancia();
	
	public Viatura getViatura();
}
