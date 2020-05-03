package br.edu.pattertproject.fireman.part2.composite_pattern;

import br.edu.pattertproject.fireman.part1.entites.person.Endereco;

public class Trecho implements ITrecho {
	private Endereco origem;
	private Endereco destino;
	private double trajeto;

	public Trecho(Endereco origem, Endereco destino) {
		this.origem = origem;
		this.destino = destino;
	}

	@Override
	public Endereco getOrigem() {
		return this.origem;
	}

	@Override
	public Endereco getDestino() {
		return this.destino;
	}

	@Override
	public void setDistancia(double distancia) {
		this.trajeto = distancia;
	}

	@Override
	public double getDistancia() {
		return this.trajeto;
	}

	@Override
	public String toString() {
		return "Trecho | {origem:" + origem + "}, {destino:" + destino + "} , {distancia:" + trajeto + "} \n";
	}
}
