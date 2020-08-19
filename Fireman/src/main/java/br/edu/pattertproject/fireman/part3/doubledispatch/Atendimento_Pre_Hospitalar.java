package br.edu.pattertproject.fireman.part3.doubledispatch;

public class Atendimento_Pre_Hospitalar extends Ocorrencia {
	private String sintomas;
	private Complexidade_Ocorrencia complexidade_Ocorrencia;
	private TipoAtendimentoPreHospitalarMovel tipoAtendimentoPreHospitalar;

	public Atendimento_Pre_Hospitalar(Endereco endereco) {
		super(endereco);
	}

	public String getSintomas() {
		return sintomas;
	}

	public void setSintomas(String sintomas) {
		this.sintomas = sintomas;
	}

	public Complexidade_Ocorrencia getComplexidade_Ocorrencia() {
		return complexidade_Ocorrencia;
	}

	public void setComplexidade_Ocorrencia(Complexidade_Ocorrencia complexidade_Ocorrencia) {
		this.complexidade_Ocorrencia = complexidade_Ocorrencia;
	}

	public TipoAtendimentoPreHospitalarMovel getTipoAtendimentoPreHospitalar() {
		return tipoAtendimentoPreHospitalar;
	}

	public void setTipoAtendimentoPreHospitalar(TipoAtendimentoPreHospitalarMovel tipoAtendimentoPreHospitalar) {
		this.tipoAtendimentoPreHospitalar = tipoAtendimentoPreHospitalar;
	}

}
