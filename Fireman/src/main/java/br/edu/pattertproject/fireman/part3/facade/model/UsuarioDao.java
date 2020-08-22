package br.edu.pattertproject.fireman.part3.facade.model;

import java.util.Map;
import br.edu.pattertproject.fireman.part3.facade.CamposUsuario;
import br.edu.pattertproject.fireman.part3.facade.model.usuario.Usuario;

public class UsuarioDao implements IDao {

	@Override
	public void add(Map<Object, Object> lista, Object object) throws Exception {

		Usuario usuario = null;

		if (object instanceof Usuario) {
			usuario = (Usuario) object;
			String identificador = (String) lista.get(CamposUsuario.IDENTIFICADOR.getDescricao());
			String senha = (String) lista.get(CamposUsuario.SENHA.getDescricao());

			usuario.setIdentificador(identificador);
			usuario.setSenha(senha);
			System.out.println("Usuário cadastrado com sucesso !");
			return;
		}

		throw new Exception("Não foi possível cadastrar o usuário");
	}

	
	@Override
	public void listar() {

	}


	@Override
	public Object buscar(Object key) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}
