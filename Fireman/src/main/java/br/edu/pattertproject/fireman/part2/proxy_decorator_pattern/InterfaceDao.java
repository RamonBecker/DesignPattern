package br.edu.pattertproject.fireman.part2.proxy_decorator_pattern;

import br.edu.pattertproject.fireman.exception.ErrorAddEmpresa;
import br.edu.pattertproject.fireman.exception.ErrorBuscarEmpresa;
import br.edu.pattertproject.fireman.exception.ErrorRemoverEmpresa;

public interface InterfaceDao {

	public <K, V> void add(K key, V value) throws ErrorAddEmpresa;

	public <K, V> Object buscar(K key, V value) throws ErrorBuscarEmpresa;

	public <K, V> Object remover(K key, V value) throws ErrorRemoverEmpresa;

	default void setInterfaceDao(InterfaceDao interfaceDao) {
	}

}
