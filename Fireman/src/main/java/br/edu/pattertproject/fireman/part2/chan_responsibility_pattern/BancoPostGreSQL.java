package br.edu.pattertproject.fireman.part2.chan_responsibility_pattern;

import java.util.Map;

import br.edu.pattertproject.fireman.exception.ErrorSearchList;

public class BancoPostGreSQL extends RecuperarDado implements InterfaceDao {

	public BancoPostGreSQL() {
		super();
		getListsEmpresas();
		getListsOcorrências();
	}

	public BancoPostGreSQL(RecuperarDado recuperarDado) {
		super(recuperarDado);
		getListsEmpresas();
		getListsOcorrências();

	}

	@Override
	protected <T> Object recuperarDado(String nome, Map<String, T> map) {

		Object dadoBuscado = null;
		try {
			dadoBuscado = buscarLista(map, nome);
		} catch (ErrorSearchList e) {
			System.err.println(e.getMessage());
		}

		return dadoBuscado;
	}

	@Override
	protected <T> Object buscarLista(Map<String, T> map, String nome) throws ErrorSearchList {
		if (map.containsKey(nome)) {
			return map.get(nome);
		}
		throw new ErrorSearchList("A key: " + nome + " não se encontra na lista:" + this);
	}

	

	@Override
	public void add(Object key, Object value, Map<Object, Object> map) {
		map.put(key, value);
		
	}

	
	@Override
	public String toString() {
		return "BancoPostGreSQL {ListsEmpresas:" + getListsEmpresas() + "} \n" + "" + "}\n" + " {ListsOcorrências:"
				+ getListsOcorrências() + "}\n";
	}




}
