package br.edu.pattertproject.fireman.part2.static_factory_pattern;

import java.util.ArrayList;
import java.util.List;
import br.edu.pattertproject.fireman.part1.entites.documents.DocumentoCNPJ;
import br.edu.pattertproject.fireman.part1.entites.documents.NullCNPJ;

public class FactoryEmpresa {

	private static List<String> palavras = new ArrayList<String>();;

	public static PessoaJuridica criaRazaoSocialNomeFantasia(String razaoSocial, String nomeFantasia) {
		palavras.clear();

		palavras.add(razaoSocial);
		palavras.add(nomeFantasia);

		PessoaJuridica pessoaJuridica = null;

		try {
			verificarVetor(palavras);

			pessoaJuridica = new Empresa(razaoSocial, nomeFantasia);
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
		return pessoaJuridica;
	}

	public static PessoaJuridica criaOcupacaoRazaoSocialNomeFantasia(String ocupacao, String razaoSocial,
			String nomeFantasia) {

		palavras.add(ocupacao);
		palavras.add(razaoSocial);
		palavras.add(nomeFantasia);
		PessoaJuridica empresa = null;

		try {
			verificarVetor(palavras);
			empresa = new Empresa(ocupacao);
			empresa.setRazaoSocial(razaoSocial);
			empresa.setNomeFantasia(nomeFantasia);

		} catch (IllegalArgumentException e) {
			System.err.println(e.getMessage());
		}

		return empresa;
	}

	public static PessoaJuridica criarDocumento(DocumentoCNPJ documentoCNPJ, String razaoSocial, String nomeFantasia,
			String ocupacao) throws Exception {
		palavras.clear();
		palavras.add(razaoSocial);
		palavras.add(nomeFantasia);
		palavras.add(ocupacao);

		Exception exception = null;

		try {

			verificarVetor(palavras);

			if (!(documentoCNPJ instanceof NullCNPJ)) {

				PessoaJuridica empresa = new Empresa(documentoCNPJ, razaoSocial, nomeFantasia, ocupacao);

				return empresa;
			} else {
				exception = new IllegalArgumentException("CNPJ inválido");

			}

		} catch (Exception e) {
			System.err.println(e.getMessage());
		}

		throw new Exception(exception);

	}

	public static PessoaJuridica criarOcupacao(String ocupacao) {
		palavras.clear();
		palavras.add(ocupacao);

		Empresa empresa = null;
		try {
			verificarVetor(palavras);

			empresa = new Empresa(ocupacao);
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}

		return empresa;
	}

	private static void verificarVetor(List<String> palavras) throws IllegalArgumentException {
		for (String palavra : palavras) {
			if (!validarString(palavra)) {
				throw new IllegalArgumentException("A " + palavra + " esta vazia ou incorreta");
			}
		}
	}

	private static boolean validarString(String palavra) {
		if (!(palavra == null) && !(palavra.isEmpty())) {
			return true;
		}
		return false;
	}
}
