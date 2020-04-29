package br.edu.pattertproject.fireman.part2.chan_responsibility_pattern;

import java.util.HashMap;
import java.util.Map;
import br.edu.pattertproject.fireman.part1.entites.person.Endereco;
import br.edu.pattertproject.fireman.part1.observer_pattern.Ocorrencia;
import br.edu.pattertproject.fireman.part1.observer_pattern.Viatura;

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

		Endereco endereco = new Endereco("Rua", "Bairro", "cidade", "75");

		Ocorrencia ocorrencia = new Ocorrencia(endereco);

		Viatura viatura = new Viatura("00", "Modelo");
		viatura.setOcorrencia(ocorrencia);

		listsViaturas.put("00", viatura);
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
	public <K, V> void add(K key, V value, Map<K, V> map) {
		map.put(key, value);

	}

	@Override
	public String toString() {
		return "CacheMemory {listsEmpresas: " + getListsEmpresas() + "} \n :" + "\n" + "{listsOcorrências:"
				+ getListsViaturas() + "}\n";
	}

}
