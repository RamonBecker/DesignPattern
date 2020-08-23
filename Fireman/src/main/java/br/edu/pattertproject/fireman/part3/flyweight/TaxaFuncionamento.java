package br.edu.pattertproject.fireman.part3.flyweight;

public class TaxaFuncionamento extends Taxa {

	private Bloco bloco;

	@Override
	public Double gerarTaxa() {

		if (bloco.getArea() > 100) {
			setValor(bloco.getArea() * 0.41);
		} else {
			setValor(41.0);
		}

		return getValor();
	}

	public Bloco getBloco() {
		return bloco;
	}

	public void setBloco(Bloco bloco) {
		this.bloco = bloco;
	}

}
