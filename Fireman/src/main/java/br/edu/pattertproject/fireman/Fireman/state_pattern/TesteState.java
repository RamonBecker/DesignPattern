package br.edu.pattertproject.fireman.Fireman.state_pattern;

import br.edu.pattertproject.fireman.Fireman.entites.Empresa;

public class TesteState {

	public static void main(String[] args) {
		
		Empresa empresa = new Empresa("Empresa", "Empresa blabla");
		empresa.setInterfaceEstado(new TaxaPendente());
		
		empresa.solicitarVistoria();
		
		empresa.setTaxa(0);
		
		empresa.solicitarVistoria();
	}
}
