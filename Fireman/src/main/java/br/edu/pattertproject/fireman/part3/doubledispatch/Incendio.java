package br.edu.pattertproject.fireman.part3.doubledispatch;

import java.util.ArrayList;
import java.util.List;

import br.edu.pattertproject.fireman.part3.fluent_interfaces.Viatura;

public class Incendio extends Ocorrencia {

	private List<Viatura> viaturas;
	private TipoIncendio tipoIncendio;

	public Incendio(Endereco endereco) {
		super(endereco);
	}

	public List<Viatura> getViaturas() {
		if (this.viaturas == null) {
			this.viaturas = new ArrayList<>();
		}
		return viaturas;
	}

	public void addPropriedades(RelatorioOcorrencia relatorioOcorrencia) {
		relatorioOcorrencia.addPropriedadeTipoIncendio(tipoIncendio, getLista_Equipamentos_Utilizados());
	}

	public TipoIncendio getTipoIncendio() {
		if (tipoIncendio == null) {
			throw new IllegalArgumentException("O tipo de incêndio não pode ser vazio !");
		}
		return tipoIncendio;
	}

	public void setTipoIncendio(TipoIncendio tipoIncendio) {
		if (tipoIncendio == null) {
			throw new IllegalArgumentException("O tipo de incêndio não pode ser vazio !");
		}
		this.tipoIncendio = tipoIncendio;
	}

	@Override
	public String toString() {
		return "Incendio [viaturas=" + viaturas + ", tipoIncendio=" + tipoIncendio + "]";
	}

}
