package br.edu.pattertproject.fireman.Fireman.bridge;

public class CNPJ extends Documento {

	public CNPJ() {
	}

	public CNPJ(String documento) {
		super(documento);
	}

	public CNPJ(String documento, IntefaceDocumento interfaceDocumento) {
		super(documento, interfaceDocumento);
	}

}
