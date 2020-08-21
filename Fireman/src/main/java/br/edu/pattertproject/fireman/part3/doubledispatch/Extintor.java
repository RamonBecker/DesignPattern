package br.edu.pattertproject.fireman.part3.doubledispatch;

public class Extintor extends Equipamento {

	private int capacidade;

	public Extintor(Double custo, Integer quantidade) {
		super(custo, quantidade);
	}

	public Extintor(Double custo, Integer quantidade, int capacidade) {
		super(custo, quantidade);
		if (quantidade < 0) {
			throw new IllegalArgumentException("A capacidade não pode ser negativa");
		}

		this.capacidade = capacidade;
	}

	@Override
	public void addPropriedade(RelatorioOcorrencia relatorioOcorrencia) {
		relatorioOcorrencia.addPropriedades(getTipoOcorrencia(), this);
	}

	public int getCapacidade() {
		return capacidade;
	}

	public void setCapacidade(int capacidade) {
		if (capacidade < 0) {
			throw new IllegalArgumentException("A capacidade não pode ser negativa");
		}
		this.capacidade = capacidade;
	}

}
