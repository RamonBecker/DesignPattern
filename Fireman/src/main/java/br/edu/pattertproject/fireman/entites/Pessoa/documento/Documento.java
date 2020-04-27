package br.edu.pattertproject.fireman.entites.Pessoa.documento;

public abstract class Documento {

	private String numero_documento;

	public Documento() {
	}

	public Documento(String documento) {
		this.numero_documento = documento;
	}

	public String getNumeroDocumento() {
		return numero_documento;
	}

	public void setDocumento(String documento) {
		this.numero_documento = documento;
	}

	public abstract Documento validarDocumento();

	@Override
	public String toString() {
		return "Documento: " + numero_documento;
	}

}
