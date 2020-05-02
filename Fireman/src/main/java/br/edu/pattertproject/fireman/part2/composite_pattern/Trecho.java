package br.edu.pattertproject.fireman.part2.composite_pattern;

import br.edu.pattertproject.fireman.part1.entites.person.Endereco;
import br.edu.pattertproject.fireman.part1.observer_pattern.Viatura;

public class Trecho implements ITrecho {
	private Endereco origem;
	private Endereco destino;
	private double distancia;
	private Viatura viatura;

	public Trecho(Endereco origem, Endereco destino, double distancia, Viatura viatura) {
		this.origem = origem;
		this.destino = destino;
		this.distancia = distancia;
		this.viatura = viatura;
	}

	@Override
	public Endereco getOrigem() {
		return this.origem;
	}

	@Override
	public Endereco getDestino() {
		return this.destino;
	}

	public void setDistancia(double distancia) {
		this.distancia = distancia;
	}

	@Override
	public double getDistancia() {
		return this.distancia;
	}

	@Override
	public Viatura getViatura() {
		return this.viatura;
	}

}
