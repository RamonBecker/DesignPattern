package br.edu.pattertproject.fireman.part3.doubledispatch;

public abstract class Equipamento {
	private String modelo;
	private Double custo;
	private Integer quantidade;
	private TipoOcorrencia tipoOcorrencia;

	public Equipamento(Double custo, Integer quantidade) {

		if (custo < 0 || custo == null) {
			throw new IllegalArgumentException("O custo não pode ser negativo !");
		}

		if (quantidade < 0 || quantidade == null) {
			throw new IllegalArgumentException("A quantidade não pode negativa !");
		}

		this.custo = custo;
		this.quantidade = quantidade;
	}

	public Double getCusto() {
		return custo;
	}

	public abstract void addPropriedade(RelatorioOcorrencia relatorioOcorrencia);

	public void setCusto(Double custo) {
		if (custo < 0 || custo == null) {
			throw new IllegalArgumentException("O custo não pode ser negativo !");
		}
		this.custo = custo;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		if (modelo == null || modelo.isEmpty()) {
			throw new IllegalArgumentException("O modelo não pode ser vazio !");
		}
		this.modelo = modelo;
	}

	public Integer getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Integer quantidade) {
		if (quantidade < 0 || quantidade == null) {
			throw new IllegalArgumentException("A quantidade não pode negativa !");
		}

		this.quantidade = quantidade;
	}

	public TipoOcorrencia getTipoOcorrencia() {
		return tipoOcorrencia;
	}

	public void setTipoOcorrencia(TipoOcorrencia tipoOcorrencia) {
		if (tipoOcorrencia == null) {
			throw new IllegalArgumentException("O tipo da ocorrência não pode ser vazio");
		}
		this.tipoOcorrencia = tipoOcorrencia;
	}

	@Override
	public String toString() {
		return "Equipamento [modelo=" + modelo + ", custo=" + custo + ", quantidade=" + quantidade + "]";
	}

}
