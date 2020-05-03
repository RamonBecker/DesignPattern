package br.edu.pattertproject.fireman.part2.composite_pattern;

import br.edu.pattertproject.fireman.part1.entites.person.Endereco;

public interface ITrecho {

	public Endereco getOrigem();

	public Endereco getDestino();
	
	public void setDistancia(double distancia);

	public double getDistancia();

}
