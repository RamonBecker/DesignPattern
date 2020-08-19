package br.edu.pattertproject.fireman.part3.doubledispatch;

import java.util.List;


import br.edu.pattertproject.fireman.part3.fluent_interfaces.Viatura;

public class Incendio extends Ocorrencia {
	
	private List<Viatura> viaturas;
	private Complexidade_Ocorrencia complexidade_Ocorrencia;
	private String tipoIncendio;

	public Incendio(Endereco endereco) {
		super(endereco);
	}

}
