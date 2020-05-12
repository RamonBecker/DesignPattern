package br.edu.pattertproject.fireman.part2.static_factory_pattern;

import java.util.ArrayList;
import java.util.List;


public class FactoryEmpresa {

	private static List<String> palavras = new ArrayList<String>();

	public static Empresa criaRazaoSocialNomeFantasia(String razaoSocial, String nomeFantasia) {
		palavras.clear();

		palavras.add(razaoSocial);
		palavras.add(nomeFantasia);

		Empresa pessoaJuridica = null;

		try {
			verificarVetor(palavras);

			pessoaJuridica = new Empresa(razaoSocial, nomeFantasia);
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
		return pessoaJuridica;
	}

	public static Empresa criaOcupacaoRazaoSocialNomeFantasia(String ocupacao, String razaoSocial,
			String nomeFantasia) {

		palavras.add(ocupacao);
		palavras.add(razaoSocial);
		palavras.add(nomeFantasia);
		Empresa empresa = null;

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

	public static Empresa criarDocumento(DocumentoCNPJ documentoCNPJ, String razaoSocial, String nomeFantasia,
			String ocupacao) throws Exception {
		palavras.clear();
		palavras.add(razaoSocial);
		palavras.add(nomeFantasia);
		palavras.add(ocupacao);

		Exception exception = null;

		try {

			verificarVetor(palavras);

			if (!(documentoCNPJ == null)) {

				return new Empresa(documentoCNPJ, razaoSocial, nomeFantasia, ocupacao);

				
			} 
		} catch (Exception e) {
			System.out.println(e.getMessage());
			exception = e;
			//e.printStackTrace();
		}

		throw new Exception(exception);

	}

	public static Empresa criarOcupacao(String ocupacao) {
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
