package br.edu.pattertproject.fireman.Fireman.bridge;

public class CPF extends Documento {

	public CPF() {
	}

	public CPF(String documento) {
		super(documento);
	}

	public CPF(String documento, IntefaceDocumento interfaceDocumento) {
		super(documento, interfaceDocumento);
	}

}
