package br.edu.pattertproject.fireman.part3.facade.model;

public class Usuario {
	private String identificador;
	private String senha;

	public Usuario(String identificador, String senha) {
		if (identificador.isEmpty() || identificador == null) {
			throw new IllegalArgumentException("O identificador não pode ser vazio !");
		}
		if (senha.isEmpty() || senha == null) {
			throw new IllegalArgumentException("A senha não pode ser vazia !");
		}

		this.identificador = identificador;
		this.senha = senha;
	}

	public String getIdentificador() {
		return identificador;
	}

	public void setIdentificador(String identificador) {
		if (identificador.isEmpty() || identificador == null) {
			throw new IllegalArgumentException("O identificador não pode ser vazio !");
		}

		this.identificador = identificador;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		if (senha.isEmpty() || senha == null) {
			throw new IllegalArgumentException("A senha não pode ser vazia !");
		}

		this.senha = senha;
	}

}
