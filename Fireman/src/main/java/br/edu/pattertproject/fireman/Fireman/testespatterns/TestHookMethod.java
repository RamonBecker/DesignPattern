package br.edu.pattertproject.fireman.Fireman.testespatterns;

import br.edu.pattertproject.fireman.Fireman.hook_method.Revisao;
import br.edu.pattertproject.fireman.Fireman.hook_method.RevisaoEquipamentos;
import br.edu.pattertproject.fireman.Fireman.hook_method.RevisaoMecanica;
import br.edu.pattertproject.fireman.Fireman.observer_pattern.Viatura;

public class TestHookMethod {

	public static void main(String[] args) {
		Viatura viatura = new Viatura("Viatura", "asdassa");
		
		
		Revisao revisaoEquipamentos = new RevisaoEquipamentos();
		System.out.println("Revisao de Equipamentos");
		revisaoEquipamentos.revisao();
		
		Revisao revisaoMecanica = new RevisaoMecanica();
		System.out.println("Revisao Mecanica");
		revisaoMecanica.revisao();

	}

}
