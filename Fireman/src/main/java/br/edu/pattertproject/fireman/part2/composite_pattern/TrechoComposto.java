/**
 * 
 */
package br.edu.pattertproject.fireman.part2.composite_pattern;

import java.text.DecimalFormat;
import java.text.ParseException;
import br.edu.pattertproject.fireman.part1.entites.person.Endereco;
import br.edu.pattertproject.fireman.part1.observer_pattern.Viatura;

public class TrechoComposto implements ITrecho {
	private ITrecho trechoA;
	private ITrecho trechoB;
	private double tempoPercorrido;
	private double deslocamento;
	private Viatura viatura;

	public TrechoComposto(ITrecho trechoA, ITrecho trechoB, Viatura viatura) {
		verificarDestino(trechoA, trechoB);
		this.trechoA = trechoA;
		this.trechoB = trechoB;
		this.viatura = viatura;
	}

	private void verificarDestino(ITrecho trechoA, ITrecho trechoB) {

		if (!trechoA.getDestino().getCidade().contentEquals(trechoB.getOrigem().getCidade())) {
			throw new IllegalArgumentException("A cidade da origem não é igual a cidade do destino");
		}

		else if (!trechoA.getDestino().getBairro().contentEquals(trechoB.getOrigem().getBairro())) {
			throw new IllegalArgumentException("O Bairro da origem não é igual ao bairro do destino");
		}

		else if (!trechoA.getDestino().getRua().contentEquals(trechoB.getOrigem().getRua())) {
			throw new IllegalArgumentException("A rua da origem não é igual ao bairro do destino");
		}

	}

	@Override
	public Endereco getOrigem() {
		return trechoA.getOrigem();
	}

	@Override
	public Endereco getDestino() {
		return trechoB.getDestino();
	}

	public void setDeslocamento(double deslocamento) {
		this.deslocamento = deslocamento;
	}

	public double getDeslocamento() {
		return deslocamento;
	}

	@Override
	public void setDistancia(double distancia) {
		this.deslocamento = distancia;

	}

	@Override
	public double getDistancia() {
		return trechoA.getDistancia() + trechoB.getDistancia();
	}

	public double getTempoPercorrido() {
		return tempoPercorrido;
	}

	public Viatura getViatura() {
		return viatura;
	}

	public void setViatura(Viatura viatura) {
		this.viatura = viatura;
	}

	public void setTempoPercorrido(double tempoPercorrido) {
		this.tempoPercorrido = tempoPercorrido;
	}

	public void calcDeslocamento() {

		this.deslocamento = trechoB.getDistancia() - trechoA.getDistancia();
		System.out.println("Trecho A: " + trechoA.getDistancia() + " KM");
		System.out.println("Trecho B: " + trechoB.getDistancia() + " KM");
		System.out.println("O deslocamento da viatura foi de: " + deslocamento + " KM");
	}

	public void calcTempoPercorrido() throws ParseException {

		this.tempoPercorrido = this.getDistancia() / this.viatura.getVelocidade();

		DecimalFormat formatador = new DecimalFormat("#,##0.00");

		String valor_em_Horas_TempoPercorrido = formatador.format(tempoPercorrido);

		Number parse = formatador.parse(valor_em_Horas_TempoPercorrido);

		double horaFormatado = parse.doubleValue();

		double minutos = horaFormatado * 60;

		String valor_em_minutos_TempoPercorrido = formatador.format(minutos);

		parse = formatador.parse(valor_em_minutos_TempoPercorrido);

		double minutosFormatado = parse.doubleValue();

		System.out.println("Tempo percorrido em horas: " + horaFormatado);
		System.out.println("Tempo percorrido em minutos: " + minutosFormatado);
	}

	public void calcVelocidadeMedia() {
		double velocidadeMedia = this.getDistancia() / tempoPercorrido;
		System.out.println("A velocidade Média é de:" + velocidadeMedia);
	}

	@Override
	public String toString() {
		return "TrechoComposto {{ponto_de_partida:" + trechoA + "}} \n " + "{{trechoB:" + trechoB + "}} \n"
				+ "{tempoPercorrido:" + tempoPercorrido + "} \n" + "{deslocamento=" + deslocamento + "}\n" + "{viatura="
				+ viatura + "}\n";
	}
}
