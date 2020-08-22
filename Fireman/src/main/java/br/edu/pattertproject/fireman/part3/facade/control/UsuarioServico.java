package br.edu.pattertproject.fireman.part3.facade.control;

import java.util.HashMap;
import java.util.Map;

import br.edu.pattertproject.fireman.part3.facade.dao.IDao;
import br.edu.pattertproject.fireman.part3.facade.dao.UsuarioDao;
import br.edu.pattertproject.fireman.part3.facade.model.usuario.Usuario;

public class UsuarioServico {
	private IDao iDao;
	private Map<Object, Object> argumentos;

	public UsuarioServico() {
		setiDao(new UsuarioDao());
	}

	public void add(String identificador, String senha, String senhaNovamente) {
		getArgumentos().put(CamposUsuario.IDENTIFICADOR.getDescricao(), identificador);
		getArgumentos().put(CamposUsuario.SENHA.getDescricao(), senha);
		getArgumentos().put(CamposUsuario.SENHANOVAMENTE.getDescricao(), senhaNovamente);

		try {
			iDao.add(getArgumentos(), new Usuario());
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}

	public void buscar(String identificador) {
		try {
			iDao.buscar(identificador);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public void listar() {
		iDao.listar();
	}
	
	private void setiDao(IDao iDao) {
		this.iDao = iDao;
	}

	public Map<Object, Object> getArgumentos() {
		if (argumentos == null) {
			argumentos = new HashMap<Object, Object>();
		}
		return argumentos;
	}

}
