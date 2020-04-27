package br.edu.pattertproject.fireman.part1.null_objects;

import br.edu.pattertproject.fireman.part1.bridge_pattern.BridgeClassificacaoRisco;
import br.edu.pattertproject.fireman.part1.entites.Vistoria;

public class NullTipoVistoria extends Vistoria {

	public NullTipoVistoria() {
	}

	public BridgeClassificacaoRisco getBridgeClassificacaoRisco() {
		return null;
	}

}
