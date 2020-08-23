package br.edu.pattertproject.fireman.part3.flyweight;

public abstract class Taxa {

	private Double valor;

	public abstract Double gerarTaxa();

	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}

}
