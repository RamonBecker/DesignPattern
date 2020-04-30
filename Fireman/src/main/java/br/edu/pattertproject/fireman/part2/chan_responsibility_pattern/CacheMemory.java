package br.edu.pattertproject.fireman.part2.chan_responsibility_pattern;

import java.util.HashMap;
import java.util.Map;
import br.edu.pattertproject.fireman.part1.entites.Empresa;
import br.edu.pattertproject.fireman.part1.observer_pattern.Viatura;
import br.edu.pattertproject.fireman.part2.proxy_decorator_pattern.InterfaceDao;

public class CacheMemory extends RecuperarDado implements InterfaceDao {

	private static CacheMemory cacheMemory;

	public CacheMemory() {
		super();
		listsEmpresas = new HashMap<>();
		listsViaturas = new HashMap<>();
	}

	public CacheMemory(RecuperarDado recuperador) {
		super(recuperador);
		listsEmpresas = new HashMap<>();
		listsViaturas = new HashMap<>();
	}

	public static CacheMemory getInstance() {
		if (cacheMemory == null) {
			cacheMemory = new CacheMemory();
		}
		return cacheMemory;
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
		
		if(value instanceof Viatura) {
			listsViaturas.put((String)key, (Viatura)value);
		}

	}

	@Override
	public <K, V> Object buscar(K key, V value) {

		if (value instanceof Empresa) {
			return listsEmpresas.get(key);
		}

		if (value instanceof Viatura) {
			return listsViaturas.get(key);
		}
		return null;
	}

	@Override
	public <K, V> Object remover(K key, V value) {
		
		if(value instanceof Empresa) {
			if(listsEmpresas.containsKey(key))
				return listsEmpresas.remove(key);
		}
		
		if(value instanceof Viatura) {
			if(listsViaturas.containsKey(key)) {
				return listsViaturas.remove(key);
			}
		}
		
		return null;

	}

	@Override
	public String toString() {
		return "CacheMemory {listsEmpresas: " + getListsEmpresas() + "} \n :" + "\n" + "{listsOcorrências:"
				+ getListsViaturas() + "}\n";
	}

}
