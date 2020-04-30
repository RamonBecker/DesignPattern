package br.edu.pattertproject.fireman.part2.proxy_decorator_pattern;

import java.util.Map;

public class EmpresaDaoDecorator implements RequisicaoProxy {
	private static RequisicaoProxy requisicaoProxy;

	public static RequisicaoProxy getInstance() {
		if (requisicaoProxy == null) {
			requisicaoProxy = new EmpresaDaoProxy();
		}
		return requisicaoProxy;
	}

	@Override
	public <K, V> void add(K key, V value, Map<K, V> map) {
		if (key != null & value != null & map != null) {
			getInstance().add(key, value, map);
		}
	}

	@Override
	public <K, V> Object buscar(K key, Map<K, V> map) {
		if (key != null & map != null) {
			return getInstance().buscar(key, map);
		}
		return null;
	}

	@Override
	public <K, V> Object remover(K key, Map<K, V> map) {
		if (key != null & map != null) {
			return getInstance().remover(key, map);
		}
		return null;
	}

}
