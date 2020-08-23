package br.edu.pattertproject.fireman.part3.flyweight;

public class TaxaHabitese extends Taxa {

	private Edificacao edificacao;

	@Override
	public Double gerarTaxa() {
		Edificacao edificacao = getEdificacao();

		if (edificacao.getArea() > 100) {
			setValor((edificacao.getArea() * 0.41) + (edificacao.getArea() * 0.71));
		} else {
			setValor(edificacao.getArea() * 0.71);
		}

		return getValor();
	}

	public Edificacao getEdificacao() {
		return edificacao;
	}

	public void setEdificacao(Edificacao edificacao) {
		this.edificacao = edificacao;
	}

}
