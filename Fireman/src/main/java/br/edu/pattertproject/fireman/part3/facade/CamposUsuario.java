package br.edu.pattertproject.fireman.part3.facade;

public enum CamposUsuario {
	IDENTIFICADOR("Identificador"), 
	SENHA("Senha");

	private String descricao;

	private CamposUsuario(String descricao) {
		this.descricao = descricao;
	}

	public String getDescricao() {
		return descricao;
	}

}
