package br.edu.pattertproject.fireman.part2.chan_responsibility_pattern;

import java.util.HashMap;
import java.util.Map;
import br.edu.pattertproject.fireman.exception.ErrorSearchList;

public class CacheMemory extends RecuperarDado implements InterfaceDao {

	private static CacheMemory cacheMemory;

	private CacheMemory() {
		super();
		listsEmpresas = new HashMap<>();
		listsOcorrências = new HashMap<>();
	}

	public CacheMemory(RecuperarDado recuperador) {
		super(recuperador);
		listsEmpresas = new HashMap<>();
		listsOcorrências = new HashMap<>();
	}

	public static CacheMemory getInstance() {
		if (cacheMemory == null) {
			cacheMemory = new CacheMemory();
		}
		return cacheMemory;
	}

	@Override
	protected <K, V> Object buscarLista(Map<K, V> map, String nome) throws ErrorSearchList {
		if (map.containsKey(nome)) {
			return map.get(nome);
		}
		throw new ErrorSearchList("A key: " + nome + " não se encontra na lista:" + this);
	}

	@Override
	protected <K, V> Object recuperarDado(String nome, Map<K, V> map) {
		Object dadoBuscado = null;
		try {
			dadoBuscado = buscarLista(map, nome);
		} catch (ErrorSearchList e) {
			System.err.println(e.getMessage());
		}

		return dadoBuscado;
	}

	@Override
	public <K, V> void add(K key, V value, Map<K, V> map) {
		map.put(key, value);

	}

	@Override
	public String toString() {
		return "CacheMemory {listsEmpresas: " + getListsEmpresas() + "} \n :" + "\n" + "{listsOcorrências:"
				+ getListsOcorrências() + "}\n";
	}

}
