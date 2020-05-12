package br.edu.pattertproject.fireman.part2.chan_responsibility_pattern;

import java.util.HashMap;
import java.util.Map;
import br.edu.pattertproject.fireman.part1.entites.Empresa;
import br.edu.pattertproject.fireman.part2.proxy_decorator_pattern.InterfaceDao;

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
		return "BancoPostGreSQL {ListsEmpresas:" + getListsEmpresas() + "} \n" + "" + "}\n" + " {ListsOcorrências:"
				+ getListsViaturas() + "}\n";
	}

}
