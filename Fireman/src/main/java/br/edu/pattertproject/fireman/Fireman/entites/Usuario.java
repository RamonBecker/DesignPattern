package br.edu.pattertproject.fireman.Fireman.entites;

public class Usuario extends PessoaFisica {

	private String nomeUsuario;
	private String senha;

	public Usuario(String nome, String sobrenome) {
		super(nome, sobrenome);
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
}
