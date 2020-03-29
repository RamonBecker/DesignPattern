package br.edu.pattertproject.fireman.Fireman.null_objects;

import br.edu.pattertproject.fireman.Fireman.observer_pattern.Viatura;

public class NullViatura extends Viatura{

	public NullViatura() {
		System.out.println("Não foi possivel encontrar essa viatura");
	}
}
