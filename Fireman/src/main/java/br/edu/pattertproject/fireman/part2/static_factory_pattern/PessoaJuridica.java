package br.edu.pattertproject.fireman.part2.static_factory_pattern;


public class PessoaJuridica extends Pessoa {
	protected String razaoSocial;
	protected String nomeFantasia;

	public PessoaJuridica() {
	}

	public PessoaJuridica(String razaoSocial) {
		this.razaoSocial = razaoSocial;
	}

	public PessoaJuridica(String razaoSocial, String nomeFantasia) {
		this.razaoSocial = razaoSocial;
		this.nomeFantasia = nomeFantasia;
	}

	public PessoaJuridica(Documento documento, String razaoSocial, String nomeFantasia) {
		super(documento);
		this.razaoSocial = razaoSocial;
		this.nomeFantasia = nomeFantasia;
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
