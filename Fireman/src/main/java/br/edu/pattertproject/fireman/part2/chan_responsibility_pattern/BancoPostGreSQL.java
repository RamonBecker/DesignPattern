package br.edu.pattertproject.fireman.part2.chan_responsibility_pattern;

import java.util.HashMap;
import java.util.Map;

import br.edu.pattertproject.fireman.exception.ErrorSearchList;

public class BancoPostGreSQL extends RecuperarDado implements InterfaceDao {

	private static BancoPostGreSQL bancoPostGreSQL;

	private BancoPostGreSQL() {
		super();
		listsEmpresas = new HashMap<>();
		listsViaturas = new HashMap<>();
	}

	public BancoPostGreSQL(RecuperarDado recuperarDado) {
		super(recuperarDado);
		listsEmpresas = new HashMap<>();
		listsViaturas = new HashMap<>();

	}

	public static BancoPostGreSQL getInstance() {
		if (bancoPostGreSQL == null) {
			bancoPostGreSQL = new BancoPostGreSQL();
		}
		return bancoPostGreSQL;
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
		return "BancoPostGreSQL {ListsEmpresas:" + getListsEmpresas() + "} \n" + "" + "}\n" + " {ListsOcorrências:"
				+ getListsViaturas() + "}\n";
	}

}
