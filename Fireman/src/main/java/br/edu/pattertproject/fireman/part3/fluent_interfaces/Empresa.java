package br.edu.pattertproject.fireman.part3.fluent_interfaces;

public class Empresa {
	private Documento documentoCNPJ;
	private String nomeFantasia;
	private String razaoSocial;
	private String atividades;


	public Empresa possuiCNPJ(Documento documentoCNPJ) {
		this.documentoCNPJ = documentoCNPJ;
		return this;
	}

	public Empresa temNomeFantasia(String nomeFantasia) {
		this.nomeFantasia = verificarStringVaziaOuNula(nomeFantasia);
		return this;
	}

	public Empresa contemRazaoSocial(String razaoSocial) {
		this.razaoSocial = verificarStringVaziaOuNula(razaoSocial);
		return this;
	}

	public Empresa apresentaAtividades(String atividades) {
		this.atividades = verificarStringVaziaOuNula(atividades);
		return this;
	}

	public Documento getDocumentoCNPJ() {
		return documentoCNPJ;
	}

	public String getNomeFantasia() {
		return nomeFantasia;
	}

	public String getRazaoSocial() {
		return razaoSocial;
	}

	public String getAtividades() {
		return atividades;
	}

	private String verificarStringVaziaOuNula(String recebida) {
		if (recebida.isEmpty() || recebida == null) {
			throw new IllegalArgumentException(recebida + " não pode ser vazio ou nulo");
		}
		return recebida;
	}

	@Override
	public String toString() {
		return "Empresa: { CNPJ=" + documentoCNPJ + "}, {nomeFantasia=" + nomeFantasia + "}, {razaoSocial="
				+ razaoSocial + "}, {atividades=" + atividades + "}";
	}

}
