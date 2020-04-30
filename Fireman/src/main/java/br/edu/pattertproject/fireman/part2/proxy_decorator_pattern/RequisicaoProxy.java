package br.edu.pattertproject.fireman.part2.proxy_decorator_pattern;

import java.util.Map;

public interface RequisicaoProxy {

	public <K, V> void add(K key, V value, Map<K, V> map);

	public <K, V> Object buscar(K key, Map<K, V> map);

	public <K, V> Object remover(K key, Map<K, V> map);

//	public <T, K> T editar(K key, T dado);

}
