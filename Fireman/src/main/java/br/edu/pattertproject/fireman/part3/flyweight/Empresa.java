package br.edu.pattertproject.fireman.part3.flyweight;

public class Empresa extends PessoaJuridica {
	private String ocupacao;
	private Double valorTaxa;
	private Bloco bloco;
	private Edificacao edificacao;
	private Taxa taxa;

	public Empresa() {

	}

	public Empresa(Documento documento, String razaoSocial, String nomeFantasia, String ocupacao) {
		super(documento, razaoSocial, nomeFantasia);
		if (ocupacao.isEmpty() || ocupacao == null) {
			throw new IllegalArgumentException("A ocupação não pode ser vazia");
		}
		this.ocupacao = ocupacao;
	}

	public Edificacao getEdificacao() {
		return edificacao;
	}

	public void setEdificacao(Edificacao edificacao) {
		this.edificacao = edificacao;
	}

	public Taxa getTaxa() {
		return taxa;
	}

	public void setTaxa(Taxa taxa) {
		this.taxa = taxa;
	}

	public Bloco getBloco() {
		return bloco;
	}

	public void setBloco(Bloco bloco) {
		this.bloco = bloco;
	}

	public Double getValorTaxa() {
		return valorTaxa;
	}

	public void setValorTaxa(Double valorTaxa) {
		this.valorTaxa = valorTaxa;
	}

	public String getOcupacao() {
		return ocupacao;
	}

	public void setOcupacao(String ocupacao) {
		if (ocupacao.isEmpty() || ocupacao == null) {
			throw new IllegalArgumentException("A ocupação não pode ser vazia");
		}
		this.ocupacao = ocupacao;
	}

	@Override
	public String toString() {
		return "Empresa [ocupacao=" + ocupacao + ", RazaoSocial=" + getRazaoSocial() + ", NomeFantasia="
				+ getNomeFantasia() + ", DocumentoCNPJ=" + getDocumento() + "]";
	}

}
