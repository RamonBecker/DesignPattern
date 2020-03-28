package br.edu.pattertproject.fireman.Fireman.entites.Pessoa.documento;

public class Documento {

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

	@Override
	public String toString() {
		return "Documento: " + numero_documento;
	}

}
