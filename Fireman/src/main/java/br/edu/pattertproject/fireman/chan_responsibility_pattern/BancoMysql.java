package br.edu.pattertproject.fireman.chan_responsibility_pattern;

import java.util.Map;
import br.edu.pattertproject.fireman.exception.ErrorSearchList;

public class BancoMysql extends RecuperarDado {
	
	
	public BancoMysql(RecuperarDado recuperador) {
		super(recuperador);
	
		getListsEmpresas();
		getListsVistorias();
		getListsOcorrências();
	}

	@Override
	protected <T> Object buscarLista(Map<String, T> map, String nome) throws ErrorSearchList {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected <T> Object recuperarDado(String nome, Map<String, T> map) {
		// TODO Auto-generated method stub
		return null;
	}

}
