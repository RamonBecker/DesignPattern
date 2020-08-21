package br.edu.pattertproject.fireman.part3.doubledispatch;

public class PranchaResgate extends Equipamento {

	private Double peso;

	public PranchaResgate(Double custo, Integer quantidade) {
		super(custo, quantidade);
	}

	public PranchaResgate(Double custo, Integer quantidade, Double peso) {
		super(custo, quantidade);
		if (peso < 0) {
			throw new IllegalArgumentException("O peso não pode ser negativo !");
		}
		this.peso = peso;
	}

	@Override
	public void addPropriedade(RelatorioOcorrencia relatorioOcorrencia) {
		relatorioOcorrencia.addPropriedades(getTipoOcorrencia(), this);
	}

	public Double getPeso() {
		return peso;
	}

	public void setPeso(Double peso) {
		if (peso < 0) {
			throw new IllegalArgumentException("O peso não pode ser negativo !");
		}
		this.peso = peso;
	}

	@Override
	public String toString() {
		return "PranchaResgate [peso=" + peso + "]";
	}

}
