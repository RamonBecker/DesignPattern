package br.edu.pattertproject.fireman.Fireman.entites;

public abstract class PessoaJuridica extends Pessoa {

	private String razaoSocial;
	private String nomeFantasia;

	public PessoaJuridica(String nome) {
		super(nome);
	}

	public PessoaJuridica(String nome, String razaoSocial) {
		super(nome);
		this.razaoSocial = razaoSocial;
	}

	public String getRazaoSocial() {
		return razaoSocial;
	}

	public void setRazaoSocial(String razaoSocial) {
		this.razaoSocial = razaoSocial;
	}

	public String getNomeFantasia() {
		return nomeFantasia;
	}

	public void setNomeFantasia(String nomeFantasia) {
		this.nomeFantasia = nomeFantasia;
	}

	@Override
	public String toString() {
		return "PessoaJuridica [razaoSocial=" + razaoSocial + ", nomeFantasia=" + nomeFantasia + "]";
	}

}
