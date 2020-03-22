package br.edu.pattertproject.fireman.Fireman.bridge;

public class Documento {

	private String documento;
	private IntefaceDocumento interfaceDocumento;

	public Documento() {
	}

	public Documento(String documento) {
		this.documento = documento;
	}

	public Documento(String documento, IntefaceDocumento interfaceDocumento) {
		this.documento = documento;
		this.interfaceDocumento = interfaceDocumento;
	}

	public Documento validarDocumento() {
		return interfaceDocumento.validarDocumento(documento);
	}

	public String getDocumento() {
		return documento;
	}

	public IntefaceDocumento getInterfaceDocumento() {
		return interfaceDocumento;
	}

	public void setInterfaceDocumento(IntefaceDocumento interfaceDocumento) {
		this.interfaceDocumento = interfaceDocumento;
	}

	public void setDocumento(String documento) {
		this.documento = documento;
	}

	@Override
	public String toString() {
		return "Documento [documento=" + documento + ", interfaceDocumento=" + interfaceDocumento + "]";
	}

}
