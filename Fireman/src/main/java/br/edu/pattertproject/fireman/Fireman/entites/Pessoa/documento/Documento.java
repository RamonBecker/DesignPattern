package br.edu.pattertproject.fireman.Fireman.entites.Pessoa.documento;

public class Documento {

	private String numero_documento;
	private IntefaceDocumento interfaceDocumento;

	public Documento() {
	}

	public Documento(String documento) {
		this.numero_documento = documento;
	}

	public Documento(String documento, IntefaceDocumento interfaceDocumento) {
		this.numero_documento = documento;
		this.interfaceDocumento = interfaceDocumento;
	}

	public Documento validarDocumento() {
		return interfaceDocumento.validarDocumento(numero_documento);
	}

	public String getNumeroDocumento() {
		return numero_documento;
	}

	public IntefaceDocumento getInterfaceDocumento() {
		return interfaceDocumento;
	}

	public void setInterfaceDocumento(IntefaceDocumento interfaceDocumento) {
		this.interfaceDocumento = interfaceDocumento;
	}

	public void setDocumento(String documento) {
		this.numero_documento = documento;
	}

	@Override
	public String toString() {
		return "Documento: " + numero_documento;
	}

}
