package br.edu.pattertproject.fireman.Fireman.bridge_pattern;

import java.util.Scanner;

import br.edu.pattertproject.fireman.Fireman.bridge_pattern.edificacao.VistoriaParcial;
import br.edu.pattertproject.fireman.Fireman.dao.DaoVistoria;
import br.edu.pattertproject.fireman.Fireman.entites.Empresa;
import br.edu.pattertproject.fireman.Fireman.entites.Vistoria;
import br.edu.pattertproject.fireman.Fireman.entites.Pessoa.documento.Documento;

public class Main {

	public static void main(String[] args) {
		Empresa empresa = new Empresa(new Documento("teste"), "teste", "teste", "teste"); 
		
		
		DaoVistoria daoVistoria = new DaoVistoria();
		
		String retorno = daoVistoria.questionarioFatorRisco(new RiscoElevado(), "OP", new Scanner(System.in));
		
		VistoriaParcial vistoria = new VistoriaParcial();
		
		vistoria.setBridgeClassificacaoRisco(new RiscoElevado());
		
		vistoria.processaClassificacaoRisco(retorno);
		
		System.out.println("Retorno"+retorno);
		
		System.out.println(vistoria.processaClassificacaoRisco(retorno));
	}

}
