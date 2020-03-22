package br.edu.pattertproject.fireman.Fireman.teste;

import br.edu.pattertproject.fireman.Fireman.strategy_pattern.TaxaAnual;
import br.edu.pattertproject.fireman.Fireman.strategy_pattern.TaxaHabitese;
import br.edu.pattertproject.fireman.Fireman.strategy_pattern.TipoTaxa;
import br.edu.pattertproject.fireman.Fireman.strategy_pattern.Vistoria;

public class MainTest {

	public static void main(String[] args) {

		Vistoria vistoria = new Vistoria();
		vistoria.setStrategyTaxa(TipoTaxa.values()[0].obterTipoTaxa());
		vistoria.setTaxa(100);

		System.out.println(vistoria.getTaxa());
		System.out.println(TipoTaxa.values()[0]);
		System.out.println(TipoTaxa.values()[1]);
	}

}
