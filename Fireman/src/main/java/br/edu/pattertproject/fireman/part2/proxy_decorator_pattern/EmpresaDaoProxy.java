package br.edu.pattertproject.fireman.part2.proxy_decorator_pattern;

import java.util.Map;

import br.edu.pattertproject.fireman.part2.chan_responsibility_pattern.InterfaceDao;

public class EmpresaDaoProxy implements RequisicaoProxy {
	private InterfaceDao interfaceDao;

	@Override
	public <K, V> void add(K key, V value, Map<K, V> map) {
		interfaceDao.add(key, value, map);
	}

	@Override
	public <K, V> Object buscar(K key, Map<K, V> map) {
		return interfaceDao.buscar(key, map);
	}

	@Override
	public <K, V> Object remover(K key, Map<K, V> map) {
		return interfaceDao.remover(key, map);
	}
}
