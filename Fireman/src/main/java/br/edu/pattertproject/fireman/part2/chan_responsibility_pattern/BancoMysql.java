package br.edu.pattertproject.fireman.part2.chan_responsibility_pattern;

import java.util.HashMap;
import java.util.Map;
import br.edu.pattertproject.fireman.part1.entites.Empresa;
import br.edu.pattertproject.fireman.part2.proxy_decorator_pattern.InterfaceDao;;

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
	protected <K, V> Object buscarLista(Map<K, V> map, String nome) {
		if (map.containsKey(nome)) {
			return map.get(nome);
		}
		return null;
	}

	@Override
	protected <K, V> Object recuperarDado(String nome) {
		Object dadoBuscado = null;

		dadoBuscado = buscarLista(listsEmpresas, nome);

		if (dadoBuscado == null) {
			dadoBuscado = buscarLista(listsViaturas, nome);
		}

		return dadoBuscado;
	}

	@Override
	public <K, V> void add(K key, V value) {
		if (value instanceof Empresa) {
			listsEmpresas.put((String) key, (Empresa) value);
		}
	}

	@Override
	public <K, V> Object buscar(K key, V value) {

		if (value instanceof Empresa) {
			if (listsEmpresas.containsKey(key)) {
				return listsEmpresas.get(key);
			}
		}
		return null;
	}

	@Override
	public <K, V> Object remover(K key, V value) {
		if (value instanceof Empresa) {
			if (listsEmpresas.containsKey(key)) {
				return listsEmpresas.remove(key);
			}
		}

		return null;

	}

	@Override
	public String toString() {
		return "BancoMysql {ListsEmpresas:" + getListsEmpresas() + "} \n" + "{ListsOcorrências:" + getListsViaturas()
				+ "} \n";
	}

}
