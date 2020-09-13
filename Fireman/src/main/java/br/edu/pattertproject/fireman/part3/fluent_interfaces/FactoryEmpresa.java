package br.edu.pattertproject.fireman.part3.fluent_interfaces;

public class FactoryEmpresa {

	public static Empresa criarRazaoSocial(String razaoSocial) {
		Empresa empresa = new Empresa().contemRazaoSocial(razaoSocial);
		return empresa;
	}

	public static Empresa criarCNPJ(String cnpj) {
		DocumentoCNPJ documento = (DocumentoCNPJ) new DocumentoCNPJ().possui_Numero_Documeto(cnpj);
		documento.validarDocumento();											
		Empresa empresa = new Empresa().possuiCNPJ(documento);
		return empresa;
	}

	public static Empresa criarNomeFantasia(String nomeFantasia) {
		Empresa empresa = new Empresa().temNomeFantasia(nomeFantasia);
		return empresa;
	}

	public static Empresa criarAtividades(String atividades) {
		Empresa empresa = new Empresa().apresentaAtividades(atividades);
		return empresa;
	}

	public static Empresa criar_CNPJ_RazaoSocial_NomeFantansia_Atividades(String cnpj, String razaoSocial,
			String nomeFantasia, String atividades) {
		DocumentoCNPJ documento = (DocumentoCNPJ) new DocumentoCNPJ().possui_Numero_Documeto(cnpj);
		documento.validarDocumento();	
		Empresa empresa = new Empresa().possuiCNPJ(documento).contemRazaoSocial(razaoSocial)
				.temNomeFantasia(nomeFantasia).apresentaAtividades(atividades);
		return empresa;
	}
}
