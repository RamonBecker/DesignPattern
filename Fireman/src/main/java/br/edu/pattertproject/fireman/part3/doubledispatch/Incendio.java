package br.edu.pattertproject.fireman.part3.doubledispatch;

import java.util.ArrayList;
import java.util.List;

import br.edu.pattertproject.fireman.part3.fluent_interfaces.Viatura;

public class Incendio extends Ocorrencia {

	private List<Viatura> viaturas;

	public Incendio(Endereco endereco) {
		super(endereco);
	}

	public List<Viatura> getViaturas() {
		if (this.viaturas == null) {
			this.viaturas = new ArrayList<>();
		}
		return viaturas;
	}
}

