/**
 * 
 */
package br.edu.pattertproject.fireman.part2.composite_pattern;

import br.edu.pattertproject.fireman.part1.entites.person.Endereco;
import br.edu.pattertproject.fireman.part1.observer_pattern.Ocorrencia;
import br.edu.pattertproject.fireman.part1.observer_pattern.Viatura;

/**
 * @author Ramon Becker
 *
 */
public class TrechoComposto implements ITrecho {
	private ITrecho ponto_de_partida;
	private ITrecho ponto_de_chegada;
	private double tempoPercorrido;

	public TrechoComposto(ITrecho ponto_de_partida, ITrecho ponto_medio) {
		this.ponto_de_partida = ponto_de_partida;
		this.ponto_de_chegada = ponto_medio;
		verificarDestino();
	}

	private void verificarDestino() {

		if (!ponto_de_partida.getDestino().getCidade().contentEquals(ponto_de_chegada.getOrigem().getCidade())) {
			throw new IllegalArgumentException("A cidade da origem não é igual a cidade do destino");
		}

		if (!ponto_de_partida.getDestino().getBairro().equalsIgnoreCase(ponto_de_chegada.getOrigem().getBairro())) {
			throw new IllegalArgumentException("O Bairro da origem não é igual ao bairro do destino");
		}

		if (!ponto_de_partida.getDestino().getRua().equalsIgnoreCase(ponto_de_chegada.getOrigem().getRua())) {
			throw new IllegalArgumentException("A rua da origem não é igual ao bairro do destino");
		}

	}

	@Override
	public Endereco getOrigem() {
		return ponto_de_partida.getOrigem();
	}

	@Override
	public Endereco getDestino() {
		return ponto_de_chegada.getDestino();
	}

	@Override
	public double getDistancia() {
		return ponto_de_partida.getDistancia() + ponto_de_chegada.getDistancia();
	}

	public double getTempoPercorrido() {
		return tempoPercorrido;
	}

	public void setTempoPercorrido() {
		this.tempoPercorrido = this.getDistancia() / this.getViatura().getVelocidade();
	}

	@Override
	public Viatura getViatura() {
		return ponto_de_partida.getViatura();
	}

}
