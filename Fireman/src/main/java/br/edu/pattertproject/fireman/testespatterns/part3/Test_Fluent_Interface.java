package br.edu.pattertproject.fireman.testespatterns.part3;

import br.edu.pattertproject.fireman.part3.fluent_interfaces.DocumentoCNPJ;
import br.edu.pattertproject.fireman.part3.fluent_interfaces.Empresa;
import br.edu.pattertproject.fireman.part3.fluent_interfaces.FactoryEmpresa;
import br.edu.pattertproject.fireman.part3.fluent_interfaces.FactoryViatura;
import br.edu.pattertproject.fireman.part3.fluent_interfaces.Viatura;

public class Test_Fluent_Interface {
	public static void main(String[] args) {

		Viatura viatura1 = new Viatura().contem_identificacao_de_Placa("000000");

		Viatura viatura2 = FactoryViatura.criarPlaca("000000");

		Viatura viatura3 = new Viatura().contem_identificacao_de_Placa("00000").possui_Modelo("121233")
				.contem_o_fabricante("Fabricante").tem_ano_de_frabricacao("2020").necessita_combustivel("Gasolina");

		Viatura viatura4 = FactoryViatura.criar_Placa_Modelo_Fabricante_Ano_TipoCombustivel("0000", "546",
				"Tal Fabricante", "2000", "Combustivel");

		Viatura viatura5 = new Viatura().contem_identificacao_de_Placa("664").possui_Modelo("3546")
				.contem_o_fabricante("Eu não sei").tem_ano_de_frabricacao("2019")
				.necessita_combustivel("Não sei qual é");

		System.out.println(viatura1);
		System.out.println(viatura2);
		System.out.println(viatura3);
		System.out.println(viatura4);
		System.out.println(viatura5);

		
		
		System.out.println("------------------------\n");
		
		DocumentoCNPJ documentoCNPJ = new DocumentoCNPJ("23345873000131");
		Empresa empresa1 = new Empresa().possuiCNPJ(documentoCNPJ);

		Empresa empresa2 = FactoryEmpresa.criarCNPJ("23345873000131");

		Empresa empresa3 = new Empresa().temNomeFantasia("Ola");

		Empresa empresa4 = new Empresa().contemRazaoSocial("RazaoSocial");

		Empresa empresa5 = FactoryEmpresa.criarRazaoSocial("RazaoSocial");

		Empresa empresa6 = new Empresa().possuiCNPJ(documentoCNPJ).contemRazaoSocial("Teste razao social")
				.temNomeFantasia("Nome fantansia").apresentaAtividades("Comercial, venda de roupas");
		
		System.out.println(empresa1);
		System.out.println(empresa2);
		System.out.println(empresa3);
		System.out.println(empresa4);
		System.out.println(empresa5);
		System.out.println(empresa6);
	}
}
