package br.edu.pattertproject.fireman.Fireman.entites.Pessoa;

import br.edu.pattertproject.fireman.Fireman.entites.Pessoa.documento.Documento;

public class Usuario extends PessoaFisica {

	private String nomeUsuario;
	private String senha;

	public Usuario(Documento documento) {
		super(documento);
	}

	public Usuario(String nomeUsuario, String senha) {
		super(null);
		this.nomeUsuario = nomeUsuario;
		this.senha = senha;
	}

	public String getNomeUsuario() {
		return nomeUsuario;
	}

	public void setNomeUsuario(String nomeUsuario) {
		this.nomeUsuario = nomeUsuario;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	@Override
	public String toString() {
		return "Usuario: nome do usuario:" + nomeUsuario + " - senha:" + senha + "";
	}

}
