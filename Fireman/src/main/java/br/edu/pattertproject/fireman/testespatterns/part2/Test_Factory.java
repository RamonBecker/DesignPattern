package br.edu.pattertproject.fireman.testespatterns.part2;

import br.edu.pattertproject.fireman.part2.static_factory.Empresa;
import br.edu.pattertproject.fireman.part2.static_factory.FactoryEmpresa;
import br.edu.pattertproject.fireman.part2.static_factory.PessoaJuridica;

public class Test_Factory {

	public static void main(String[] args) {
		PessoaJuridica empresa = FactoryEmpresa.criaOcupacaoRazaoSocialNomeFantasia("Ocupação","Razao Social", "Nome fantasiaa");

		System.out.println(empresa);
	}

}
