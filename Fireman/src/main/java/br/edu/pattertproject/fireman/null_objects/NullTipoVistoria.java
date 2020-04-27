package br.edu.pattertproject.fireman.null_objects;


import br.edu.pattertproject.fireman.bridge_pattern.BridgeClassificacaoRisco;
import br.edu.pattertproject.fireman.entites.Vistoria;

public class NullTipoVistoria extends Vistoria {

	public NullTipoVistoria() {
	}

	public BridgeClassificacaoRisco getBridgeClassificacaoRisco() {
		return null;
	}

}
