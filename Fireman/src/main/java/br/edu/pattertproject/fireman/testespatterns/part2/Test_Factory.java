package br.edu.pattertproject.fireman.testespatterns.part2;

import br.edu.pattertproject.fireman.part2.static_factory_pattern.DocumentoCNPJ;
import br.edu.pattertproject.fireman.part2.static_factory_pattern.FactoryEmpresa;
import br.edu.pattertproject.fireman.part2.static_factory_pattern.PessoaJuridica;

public class Test_Factory {

	public static void main(String[] args) {
		PessoaJuridica empresa = null;
		
		try {
		 empresa = FactoryEmpresa.criaOcupacaoRazaoSocialNomeFantasia("Ocupação", "Razao Social",
				"Nome fantasiaa");

		System.out.println(empresa);

		empresa = FactoryEmpresa.criaRazaoSocialNomeFantasia("Razão Social", "Nome Fantasia");

		System.out.println(empresa);

		
			empresa = FactoryEmpresa.criarDocumento(new DocumentoCNPJ("14097042000105"), "Razão Social", "Nome Fantasia",
					"Ocupação1");
		} catch (Exception e) {
		
			System.out.println(e.getMessage());
		}
		
		System.out.println(empresa);
	}
	
}
