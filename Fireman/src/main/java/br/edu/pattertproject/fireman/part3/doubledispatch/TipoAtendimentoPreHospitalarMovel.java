package br.edu.pattertproject.fireman.part3.doubledispatch;

public enum TipoAtendimentoPreHospitalarMovel {
	PRIMARIO("Solicitado pelo cidadão"), 
	SECUNDARIO("Solicitado por um serviço de saúde");

	private String descricao;

	private TipoAtendimentoPreHospitalarMovel(String descricao) {
		this.descricao = descricao;
	}

	public String getDescricao() {
		return descricao;
	}

}
