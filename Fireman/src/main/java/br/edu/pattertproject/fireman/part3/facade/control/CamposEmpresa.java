package br.edu.pattertproject.fireman.part3.facade.control;

public enum CamposEmpresa {
	DOCUMENTO("Documento"), RAZAO_SOCIAL("RazaoSocial"), NOME_FANTASIA("NomeFantasia"), OCUPACAO("Ocupacao");

	private String descricao;

	private CamposEmpresa(String descricao) {
		this.descricao = descricao;
	}

	public String getDescricao() {
		return descricao;
	}

}
