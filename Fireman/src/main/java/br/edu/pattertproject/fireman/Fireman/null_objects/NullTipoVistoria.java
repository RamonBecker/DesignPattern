package br.edu.pattertproject.fireman.Fireman.null_objects;


import br.edu.pattertproject.fireman.Fireman.bridge_pattern.BridgeClassificacaoRisco;
import br.edu.pattertproject.fireman.Fireman.entites.Vistoria;

public class NullTipoVistoria extends Vistoria {

	public NullTipoVistoria() {
	}

	public BridgeClassificacaoRisco getBridgeClassificacaoRisco() {
		return null;
	}

}
