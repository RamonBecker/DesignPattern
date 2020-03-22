package br.edu.pattertproject.fireman.Fireman.bridge;

import java.util.ArrayList;

import br.edu.pattertproject.fireman.Fireman.null_objects.NullCPF;

public class ValidadorCPF implements IntefaceDocumento {

	@Override
	public Documento validarDocumento(String documento) {

		boolean validaNumero = documento.matches("[0-9]*");

		boolean verificaDocumento = false;

		if (validaNumero) {

			if (documento.length() != 11) {
				return new NullCPF();
			}

			if (documento.matches("(\\d)\\1+")) {
				return new NullCPF();
			}

			ArrayList<Integer> vetorValidador = new ArrayList<Integer>();

			int primeiroDigito = 0, segundoDigito = 0, indiceAuxPriDigito = 10, indiceAuxSegDigito = 11;

			for (int i = 0; i < documento.length(); i++) {
				vetorValidador.add((int) documento.charAt(i) - 48);
			}

			for (int i = 0; i < vetorValidador.size() - 2; i++) {
				primeiroDigito += vetorValidador.get(i) * indiceAuxPriDigito;
				indiceAuxPriDigito--;
			}

			primeiroDigito = primeiroDigito * 10 % 11;

			if (primeiroDigito == 10) {
				primeiroDigito = 0;
			}

			for (int i = 0; i < vetorValidador.size() - 1; i++) {
				segundoDigito += vetorValidador.get(i) * indiceAuxSegDigito;
				indiceAuxSegDigito--;
			}

			segundoDigito = segundoDigito * 10 % 11;

			if (segundoDigito == 10) {
				segundoDigito = 0;
			}

			if (vetorValidador.get(9) == primeiroDigito) {
				if (vetorValidador.get(10) == segundoDigito) {
					verificaDocumento = true;
				}
			}

		}

		if (verificaDocumento) {
			return new CPF(documento);
		}

		return new NullCPF();
	}

}
