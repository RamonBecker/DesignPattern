package br.edu.pattertproject.fireman.part3.doubledispatch;

public enum TipoIncendio {
	
	CLASSE_A("materiais sólidos como papel, tecido, algodão, borracha e madeira"),
	CLASSE_B("gases inflamáveis, sólidos e líquidos, como gasolina, óleo, querosene, parafina, graxas e tintas"),
	CLASSE_C("equipamentos elétricos, máquinas, transformadores, geradores, motores e quadros de força de energia"),
	CLASSE_D("metais pirofóricos como magnésio, lítio, antimônio, selênio, urânio, potássio e zircônio"),
	CLASSE_K("cozinhas industriais e residenciais, fritadeiras, fornos elétricos e grelhas");

	private String descricao;

	private TipoIncendio(String descricao) {
		this.descricao = descricao;
	}

	public String getDescricao() {
		return descricao;
	}
	
}
