package br.edu.pattertproject.fireman.testespatterns.part2;

import br.edu.pattertproject.fireman.part1.entites.documents.DocumentoCNPJ;
import br.edu.pattertproject.fireman.part2.static_factory_pattern.Empresa;
import br.edu.pattertproject.fireman.part2.static_factory_pattern.FactoryEmpresa;
import br.edu.pattertproject.fireman.part2.static_factory_pattern.PessoaJuridica;

public class Test_Factory {

	public static void main(String[] args) {
		PessoaJuridica empresa = FactoryEmpresa.criaOcupacaoRazaoSocialNomeFantasia("Ocupação", "Razao Social",
				"Nome fantasiaa");

		System.out.println(empresa);

		empresa = FactoryEmpresa.criaRazaoSocialNomeFantasia("Razão Social", "Nome Fantasia");

		System.out.println(empresa);

		try {
			empresa = FactoryEmpresa.criarDocumento(new DocumentoCNPJ("33704949000121"), "Razão Social", "Nome Fantasia",
					"Ocupação");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		System.out.println(empresa);
	}

}
