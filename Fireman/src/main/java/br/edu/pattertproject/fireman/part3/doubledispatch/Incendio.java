package br.edu.pattertproject.fireman.part3.doubledispatch;

import java.util.List;

import br.edu.pattertproject.fireman.part3.fluent_interfaces.Viatura;

public class Incendio extends Ocorrencia {

	private List<Viatura> viaturas;
	private Complexidade_Ocorrencia complexidade_Ocorrencia;
	private TipoIncendio tipoIncendio;

	public Incendio(Endereco endereco) {
		super(endereco);
	}

	public List<Viatura> getViaturas() {
		return viaturas;
	}

	public void setViaturas(List<Viatura> viaturas) {
		this.viaturas = viaturas;
	}

	public Complexidade_Ocorrencia getComplexidade_Ocorrencia() {
		return complexidade_Ocorrencia;
	}

	public void setComplexidade_Ocorrencia(Complexidade_Ocorrencia complexidade_Ocorrencia) {
		this.complexidade_Ocorrencia = complexidade_Ocorrencia;
	}

	public TipoIncendio getTipoIncendio() {
		return tipoIncendio;
	}

	public void setTipoIncendio(TipoIncendio tipoIncendio) {
		this.tipoIncendio = tipoIncendio;
	}
	
	

}
