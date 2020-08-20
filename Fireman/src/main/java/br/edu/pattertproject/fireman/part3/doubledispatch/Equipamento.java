package br.edu.pattertproject.fireman.part3.doubledispatch;

public class Equipamento {
	private int id;
	private String nome;
	private Double custo;
	private Integer quantidade;

	public Equipamento(String nome, Double custo, Integer quantidade) {
		if (nome.isEmpty() || nome == null) {
			throw new IllegalArgumentException("O nome não pode ser vazio !");
		}

		if (custo < 0 || custo == null) {
			throw new IllegalArgumentException("O custo não pode ser negativo !");
		}
		
		if(quantidade < 0 || quantidade == null) {
			throw new IllegalArgumentException("A quantidade não pode negativa !");
		}
		
		this.nome = nome;
		this.custo = custo;
		this.quantidade = quantidade;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		if (nome.isEmpty() || nome == null) {
			throw new IllegalArgumentException("O nome não pode ser vazio !");
		}

		this.nome = nome;
	}

	public Double getCusto() {
		return custo;
	}

	public void setCusto(Double custo) {
		if (custo < 0 || custo == null) {
			throw new IllegalArgumentException("O custo não pode ser negativo !");
		}
		this.custo = custo;
	}

	public Integer getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Integer quantidade) {
		if(quantidade < 0 || quantidade == null) {
			throw new IllegalArgumentException("A quantidade não pode negativa !");
		}
		
		this.quantidade = quantidade;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		if(id <= 0) {
			throw new IllegalArgumentException("O id não pode ser negativo !");
		}
		this.id = id;
	}

	@Override
	public String toString() {
		return "Equipamento [id=" + id + ", nome=" + nome + ", custo=" + custo + ", quantidade=" + quantidade + "]";
	}
	
}
