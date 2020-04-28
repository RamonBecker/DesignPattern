package br.edu.pattertproject.fireman.part2.chan_responsibility_pattern;

import java.util.HashMap;
import java.util.Map;
import br.edu.pattertproject.fireman.exception.ErrorSearchList;

public class BancoMysql extends RecuperarDado implements InterfaceDao {

	private static BancoMysql bancoMysql;

	private BancoMysql() {
		super();
		listsEmpresas = new HashMap<>();
		listsViaturas = new HashMap<>();
	}

	public BancoMysql(RecuperarDado recuperador) {
		super(recuperador);
		listsEmpresas = new HashMap<>();
		listsViaturas = new HashMap<>();
	}

	public static BancoMysql getInstance() {
		if (bancoMysql == null) {
			bancoMysql = new BancoMysql();
		}
		return bancoMysql;
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
		return "BancoMysql {ListsEmpresas:" + getListsEmpresas() + "} \n" + "{ListsOcorrências:" + getListsViaturas()
				+ "} \n";
	}

}
