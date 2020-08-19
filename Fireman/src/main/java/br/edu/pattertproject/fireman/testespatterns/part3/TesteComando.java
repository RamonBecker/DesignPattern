package br.edu.pattertproject.fireman.testespatterns.part3;

import br.edu.pattertproject.fireman.part3.command.Acelerar;
import br.edu.pattertproject.fireman.part3.command.Freiar;
import br.edu.pattertproject.fireman.part3.command.Invoker;
import br.edu.pattertproject.fireman.part3.command.Motor;
import br.edu.pattertproject.fireman.part3.command.TrocarMarcha;
import br.edu.pattertproject.fireman.part3.fluent_interfaces.Viatura;

public class TesteComando {

	public static void main(String[] args) {
		Viatura viatura = new Viatura().contem_identificacao_de_Placa("00000").possui_Modelo("121233")
				.contem_o_fabricante("Fabricante").tem_ano_de_frabricacao("2020").necessita_combustivel("Gasolina").possuiMotor(new Motor());
		
		Invoker invoker = new Invoker();
		invoker.setViatura(viatura);
		invoker.executa_acelerar(new Acelerar());
		invoker.executa_Trocar_Marcha(new TrocarMarcha());
		invoker.executa_Freiar(new Freiar());

	}

}
