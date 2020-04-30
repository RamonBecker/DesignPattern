package br.edu.pattertproject.fireman.part2.proxy_decorator_pattern;

import br.edu.pattertproject.fireman.exception.ErrorAddEmpresa;
import br.edu.pattertproject.fireman.exception.ErrorBuscarEmpresa;
import br.edu.pattertproject.fireman.exception.ErrorRemoverEmpresa;

public class EmpresaDaoDecorator implements InterfaceDao {
	private static InterfaceDao requisicaoProxy;

	public static InterfaceDao getInstance() {
		if (requisicaoProxy == null) {
			requisicaoProxy = new EmpresaDaoProxy();
		}
		return requisicaoProxy;
	}

	@Override
	public <K, V> void add(K key, V value) {
		if (key != null & value != null) {
			try {

				if (!((String) key).isBlank()) {
					getInstance().add(key, value);
				} else {
					throw new ErrorAddEmpresa("A key não pode ser vazia, erro ao adicionar a empresa");
				}
			} catch (ErrorAddEmpresa e) {
				System.err.println(e.getMessage());
			}
		}
	}

	@Override
	public <K, V> Object buscar(K key, V value) throws ErrorBuscarEmpresa {
		if (key != null & value != null) {
			try {
				if (!((String) key).isBlank()) {

					return getInstance().buscar(key, value);
				} else {
					throw new ErrorBuscarEmpresa("A key não pode ser vazia, erro ao buscar a empresa");
				}
			} catch (ErrorBuscarEmpresa e) {
				e.printStackTrace();
			}
		}
		throw new ErrorBuscarEmpresa("Erro ao buscar a empresa !");
	}

	@Override
	public <K, V> Object remover(K key, V value) throws ErrorRemoverEmpresa {
		if (key != null & value != null) {
			try {

				if (!((String) key).isBlank()) {
					return getInstance().remover(key, value);
				}else {
					throw new ErrorRemoverEmpresa("A key não pode ser vazia, erro ao remover a empresa");
				}
			} catch (ErrorRemoverEmpresa e) {
				e.printStackTrace();
			}
		}
		throw new ErrorRemoverEmpresa("Erro ao remover a empresa");
	}
}
