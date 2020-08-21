package br.edu.pattertproject.fireman.part3.doubledispatch;


public class Incendio extends Ocorrencia {

	private TipoIncendio tipoIncendio;

	public Incendio(Endereco endereco) {
		super(endereco);
	}

	public Incendio(Endereco endereco, TipoIncendio tipoIncendio) {
		super(endereco);
		if (tipoIncendio == null) {
			throw new IllegalArgumentException("O tipo de incêndio não pode ser vazio");
		}
		this.tipoIncendio = tipoIncendio;
	}

	public TipoIncendio getTipoIncendio() {
		return tipoIncendio;
	}

	public void setTipoIncendio(TipoIncendio tipoIncendio) {
		if (tipoIncendio == null) {
			throw new IllegalArgumentException("O tipo de incêndio não pode ser vazio");
		}
		this.tipoIncendio = tipoIncendio;
	}

}
