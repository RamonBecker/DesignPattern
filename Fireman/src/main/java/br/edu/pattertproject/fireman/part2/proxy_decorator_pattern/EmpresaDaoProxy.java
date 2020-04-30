package br.edu.pattertproject.fireman.part2.proxy_decorator_pattern;

import br.edu.pattertproject.fireman.exception.ErrorAddEmpresa;
import br.edu.pattertproject.fireman.exception.ErrorBuscarEmpresa;
import br.edu.pattertproject.fireman.exception.ErrorRemoverEmpresa;

public class EmpresaDaoProxy implements InterfaceDao {
	private InterfaceDao interfaceDao;

	@Override
	public <K, V> void add(K key, V value) throws ErrorAddEmpresa {
		interfaceDao.add(key, value);
	}

	@Override
	public <K, V> Object buscar(K key, V value) throws ErrorBuscarEmpresa {
		return interfaceDao.buscar(key, value);
	}

	@Override
	public <K, V> Object remover(K key, V value) throws ErrorRemoverEmpresa {
		return interfaceDao.remover(key, value);
	}

	public InterfaceDao getInterfaceDao() {
		return interfaceDao;
	}

	@Override
	public void setInterfaceDao(InterfaceDao interfaceDao) {
		this.interfaceDao = interfaceDao;
	}

	
	
	@Override
	public String toString() {
		return "EmpresaDaoProxy [interfaceDao=" + interfaceDao + "]";
	}
}
