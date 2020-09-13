package br.edu.pattertproject.fireman.part3.fluent_interfaces;

public abstract class Documento {
	private String numero_documento;

	public Documento() {
	}

	public Documento possui_Numero_Documeto(String n_Documento) {
		this.numero_documento = n_Documento;
		return this;
	}


	public String getNumeroDocumento() {
		return numero_documento;
	}

	public abstract Documento validarDocumento();

	@Override
	public String toString() {
		return "Documento: " + numero_documento;
	}
}
