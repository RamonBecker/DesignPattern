package br.edu.pattertproject.fireman.part2.chan_responsibility_pattern;

import java.util.Map;
import br.edu.pattertproject.fireman.exception.ErrorSearchList;

public class BancoMysql extends RecuperarDado implements InterfaceDao {

	public BancoMysql() {
		super();
		getListsEmpresas();
		getListsOcorrências();
	}

	public BancoMysql(RecuperarDado recuperador) {
		super(recuperador);

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
	public <K, V> void add(K key, V value, Map<K, V> map) {
		map.put(key, value);

	}

	@Override
	public String toString() {
		return "BancoMysql {ListsEmpresas:" + getListsEmpresas() + "} \n" + "{ListsOcorrências:" + getListsOcorrências()
				+ "} \n";
	}

}
