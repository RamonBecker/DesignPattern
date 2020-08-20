package br.edu.pattertproject.fireman.part3.doubledispatch;

public class Atendimento_Pre_Hospitalar extends Ocorrencia {

	private Sintomas sintomas;
	private TipoAtendimentoPreHospitalarMovel tipoAtendimentoPreHospitalar;

	public Atendimento_Pre_Hospitalar(Endereco endereco) {
		super(endereco);
	}

	public Sintomas getSintomas() {
		return sintomas;
	}

	public void setSintomas(Sintomas sintomas) {
		if (sintomas == null) {
			throw new IllegalArgumentException("O sintoma não pode ser vazio !");
		}
		this.sintomas = sintomas;
	}

	public TipoAtendimentoPreHospitalarMovel getTipoAtendimentoPreHospitalar() {
		if (tipoAtendimentoPreHospitalar == null) {
			throw new IllegalArgumentException("O tipo de atendimento está vazio");
		}
		return tipoAtendimentoPreHospitalar;
	}

	public void setTipoAtendimentoPreHospitalar(TipoAtendimentoPreHospitalarMovel tipoAtendimentoPreHospitalar) {
		if (tipoAtendimentoPreHospitalar == null) {
			throw new IllegalArgumentException("O tipo de atendimento não pode vazio");
		}
		this.tipoAtendimentoPreHospitalar = tipoAtendimentoPreHospitalar;
	}

	@Override
	public void addPropriedades(RelatorioOcorrencia relatorioOcorrencia) {
		// TODO Auto-generated method stub
		
	}

}
