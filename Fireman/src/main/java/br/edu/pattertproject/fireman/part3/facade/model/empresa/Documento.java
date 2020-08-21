package br.edu.pattertproject.fireman.part3.facade.model.empresa;

public abstract class Documento {
	private String numero_documento;

	public Documento() {
	}

	public Documento(String documento) {
		if (documento.isEmpty() || documento == null) {
			throw new IllegalArgumentException("O documento não pode ser vazio ");
		}
		this.numero_documento = documento;
	}

	public String getNumeroDocumento() {
		return numero_documento;
	}

	public void setDocumento(String documento) {
		if (documento.isEmpty() || documento == null) {
			throw new IllegalArgumentException("O documento não pode ser vazio ");
		}
		this.numero_documento = documento;
	}

	public abstract Documento validarDocumento();

	@Override
	public String toString() {
		return "Documento: " + numero_documento;
	}
}
