package br.edu.pattertproject.fireman.Fireman.entites.Pessoa.documento;

import java.util.ArrayList;

import br.edu.pattertproject.fireman.Fireman.null_objects.NullCNPJ;

public class ValidadorCNPJ implements IntefaceDocumento {

	@Override
	public Documento validarDocumento(String documento) {

		boolean validaNumero = documento.matches("[0-9]*");

		boolean verificaDocumento = false;

		if (validaNumero) {

			if (documento.length() != 14) {
				return new NullCNPJ();
			}

			if (documento.matches("(\\d)\\1+")) {
				return new NullCNPJ();
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

			for (int i = 0; i < documento.length(); i++) {
				vetor.add((int) documento.charAt(i) - 48);
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
			return new CNPJ();
		}
		return new NullCNPJ();
	}

}
