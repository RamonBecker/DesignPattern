package br.edu.pattertproject.fireman.part3.flyweight;

public abstract class PessoaJuridica {
	private String razaoSocial;
	private String nomeFantasia;
	private Documento documento;

	public PessoaJuridica() {
	}

	public PessoaJuridica(Documento documento, String razaoSocial, String nomeFantasia) {
		if (documento == null) {
			throw new IllegalArgumentException("O documento não pode ser vazio");
		}
		if (razaoSocial.isEmpty() || razaoSocial == null) {
			throw new IllegalArgumentException("A razão social não pode ser vazia");

		}
		if (nomeFantasia.isEmpty() || nomeFantasia == null) {
			throw new IllegalArgumentException("O nome fantasia não pode ser vazio");

		}
		this.documento = documento;
		this.razaoSocial = razaoSocial;
		this.nomeFantasia = nomeFantasia;
	}

	public String getRazaoSocial() {
		return razaoSocial;
	}

	public void setRazaoSocial(String razaoSocial) {
		if (razaoSocial.isEmpty() || razaoSocial == null) {
			throw new IllegalArgumentException("A razão social não pode ser vazia");

		}
		this.razaoSocial = razaoSocial;
	}

	public String getNomeFantasia() {
		return nomeFantasia;
	}

	public void setNomeFantasia(String nomeFantasia) {
		if (nomeFantasia.isEmpty() || nomeFantasia == null) {
			throw new IllegalArgumentException("O nome fantasia não pode ser vazio");

		}
		this.nomeFantasia = nomeFantasia;
	}

	public Documento getDocumento() {
		return documento;
	}

	public void setDocumento(Documento documento) {
		if (documento == null) {
			throw new IllegalArgumentException("O documento não pode ser vazio");
		}
		this.documento = documento;
	}

	@Override
	public String toString() {
		return "PessoaJuridica [razaoSocial=" + razaoSocial + ", nomeFantasia=" + nomeFantasia + ", documento="
				+ documento + "]";
	}

}
