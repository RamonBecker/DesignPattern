package br.edu.pattertproject.fireman.part3.fluent_interfaces;

import java.util.ArrayList;

public class DocumentoCNPJ extends Documento {
	public DocumentoCNPJ() {
		super();
	}

	@Override
	public Documento possui_Numero_Documeto(String n_Documento) {

		return super.possui_Numero_Documeto(n_Documento);

	}

	@Override
	public Documento validarDocumento() {

		boolean validaNumero = getNumeroDocumento().matches("[0-9]*");

		boolean verificaDocumento = false;

		if (validaNumero) {

			if (getNumeroDocumento().length() != 14) {
				throw new IllegalArgumentException("CNPJ Inválido");
			}

			if (getNumeroDocumento().matches("(\\d)\\1+")) {
				throw new IllegalArgumentException("CNPJ Inválido");
			}

			int primeiroDigito = 0, segundoDigito = 0, indiceAuxiliar = 1;

			ArrayList<Integer> pesoCNPJ = new ArrayList<Integer>() {
				{
					add(6);
					add(5);
					add(4);
					add(3);
					add(2);
					add(9);
					add(8);
					add(7);
					add(6);
					add(5);
					add(4);
					add(3);
					add(2);
				}
			};

			ArrayList<Integer> vetor = new ArrayList<Integer>();

			for (int i = 0; i < getNumeroDocumento().length(); i++) {
				vetor.add((int) getNumeroDocumento().charAt(i) - 48);
			}

			for (int i = 0; i < vetor.size() - 2; i++) {
				primeiroDigito += vetor.get(i) * pesoCNPJ.get(indiceAuxiliar);
				indiceAuxiliar++;

			}

			primeiroDigito = primeiroDigito % 11;

			if (primeiroDigito < 2) {
				primeiroDigito = 0;
			} else {
				primeiroDigito = 11 - primeiroDigito;
			}

			for (int i = 0; i < vetor.size() - 1; i++) {
				segundoDigito += vetor.get(i) * pesoCNPJ.get(i);
			}

			segundoDigito = segundoDigito % 11;

			if (segundoDigito < 2) {
				segundoDigito = 0;
			} else {
				segundoDigito = 11 - segundoDigito;
			}

			if (vetor.get(12) == primeiroDigito) {
				if (vetor.get(13) == segundoDigito) {
					verificaDocumento = true;
				}
			}
		}

		if (verificaDocumento) {
			possui_Numero_Documeto((getNumeroDocumento()));
			return this;
		}

		throw new IllegalArgumentException("CNPJ Inválido");
	}

}
