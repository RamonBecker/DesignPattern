package br.edu.pattertproject.fireman.part3.facade.control;

public enum CamposUsuario {
	IDENTIFICADOR("Identificador"), 
	SENHA("Senha"),
	SENHANOVAMENTE("SenhaNovamente");
	
	private String descricao;

	private CamposUsuario(String descricao) {
		this.descricao = descricao;
	}

	public String getDescricao() {
		return descricao;
	}

}
