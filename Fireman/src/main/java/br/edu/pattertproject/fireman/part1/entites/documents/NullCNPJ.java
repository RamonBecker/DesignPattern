package br.edu.pattertproject.fireman.part1.entites.documents;

public class NullCNPJ extends DocumentoCNPJ {

	public NullCNPJ() {
		System.out.println("CNPJ inválido, digite novamente o CNPJ");
	}

	@Override
	public String getNumeroDocumento() {
		return null;
	}

	@Override
	public void setDocumento(String documento) {
		documento = null;
	}
}
