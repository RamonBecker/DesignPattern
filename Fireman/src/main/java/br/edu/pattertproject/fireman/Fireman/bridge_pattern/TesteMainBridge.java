package br.edu.pattertproject.fireman.Fireman.bridge_pattern;

import java.util.Scanner;

import br.edu.pattertproject.fireman.Fireman.bridge_pattern.edificacao.VistoriaParcial;
import br.edu.pattertproject.fireman.Fireman.dao.DaoVistoria;
import br.edu.pattertproject.fireman.Fireman.entites.Vistoria;

public class TesteMainBridge {

	public static void main(String[] args) {

		Vistoria vistoria = new VistoriaParcial();
		
		DaoVistoria daoVistoria = new DaoVistoria();
		daoVistoria.questionarioParaVistoria(daoVistoria.getQuestionarioFatorTipoEstabelecimento(), "Tipo de estabelecimento", new Scanner(System.in));
		
		daoVistoria.questionarioParaVistoria(daoVistoria.getQuestionarioFatorDeRisco(), "Fator de risco", new 		Scanner(System.in));
		
		vistoria.setBridgeClassificacaoRisco(new RiscoElevado());
		System.out.println(vistoria.processaClassificacaoRisco(daoVistoria.getFatoresRiscosRecebidos()));
		
		
	}

}
