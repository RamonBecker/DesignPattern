package br.edu.pattertproject.fireman.testespatterns.part1;

import br.edu.pattertproject.fireman.part1.hook_method.Revisao;
import br.edu.pattertproject.fireman.part1.hook_method.RevisaoEquipamentoHospitalar;
import br.edu.pattertproject.fireman.part1.hook_method.RevisaoMecanica;
import br.edu.pattertproject.fireman.part1.observer_pattern.Viatura;

public class TestHookMethod {

	public static void main(String[] args) {
		Viatura viatura = new Viatura("Viatura", "asdassa");

		Revisao revisaoEquipamentos = new RevisaoEquipamentoHospitalar();
		System.out.println("Revisao de Equipamentos");

		viatura.setRevisao(revisaoEquipamentos);

		viatura.getRevisao().orcamento(100,500,300);

		Revisao revisaoMecanica = new RevisaoMecanica();
		System.out.println("Revisao Mecanica");

		viatura.setRevisao(revisaoMecanica);

		viatura.getRevisao().orcamento(600,800,1000);

	}

}
