package br.edu.pattertproject.fireman.Fireman.entites.Pessoa;


public class Usuario extends PessoaFisica {

	private String nomeUsuario;
	private String senha;

	public Usuario(String nome, String sobrenome) {
		super(nome, sobrenome);
	}

	public Usuario(String nome, String nomeUsuario, String senha) {
		super(nome);
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
		return "Usuario:" + nomeUsuario;
	}

}
