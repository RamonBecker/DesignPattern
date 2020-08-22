package br.edu.pattertproject.fireman.part3.facade.dao;

import java.util.HashMap;
import java.util.Map;
import br.edu.pattertproject.fireman.part3.facade.control.CamposUsuario;
import br.edu.pattertproject.fireman.part3.facade.model.usuario.Usuario;

public class UsuarioDao implements IDao {
	private Map<String, Usuario> listaUsuario;

	@Override
	public void add(Map<Object, Object> lista, Object object) throws Exception {

		Usuario usuario = null;

		if (object instanceof Usuario) {
			usuario = (Usuario) object;
			String identificador = (String) lista.get(CamposUsuario.IDENTIFICADOR.getDescricao());
			String senha = (String) lista.get(CamposUsuario.SENHA.getDescricao());
			String senhaNovamente = (String) lista.get(CamposUsuario.SENHANOVAMENTE.getDescricao());
			if (!senhaNovamente.equals(senha)) {
				throw new Exception("Não foi possível cadastrar o usuário, as senhas não coincidem");
			}

			usuario.setIdentificador(identificador);
			usuario.setSenha(senha);
			System.out.println("Usuário cadastrado com sucesso !");
			getListaUsuario().put(usuario.getIdentificador(), usuario);
			return;
		}

		throw new Exception("Não foi possível cadastrar o usuário");
	}

	@Override
	public void listar() {
		if (getListaUsuario().isEmpty()) {
			System.out.println("Não há usuário cadastrados !");
			return;
		}

		for (String key : getListaUsuario().keySet()) {
			System.out.println(getListaUsuario().get(key));
		}

	}

	@Override
	public Object buscar(Object key) throws Exception {
		String identificador = (String) key;

		if (getListaUsuario().containsKey(identificador)) {
			System.out.println("Usuario retornado");
			System.out.println(getListaUsuario().get(identificador));
			return getListaUsuario().get(identificador);
		}

		throw new Exception("Usuário não encontrado !");
	}

	private Map<String, Usuario> getListaUsuario() {
		if (listaUsuario == null) {
			listaUsuario = new HashMap<String, Usuario>();
		}
		return listaUsuario;
	}

}
