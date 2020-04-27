package br.edu.pattertproject.fireman.null_objects;

import java.util.Scanner;

import br.edu.pattertproject.fireman.dao.DaoOcorrencia;
import br.edu.pattertproject.fireman.observer_pattern.CentralDeOcorrencia;

public class NullCentralOcorrencia extends CentralDeOcorrencia {
	
	public NullCentralOcorrencia() {
		System.out.println("Não foi possível buscar a central de ocorrência");
	}
	
//	public CentralDeOcorrencia listarCentralOcorrencia(Scanner scanner, DaoOcorrencia daoOcorrencia) {
//		if (daoOcorrencia.getListCentralDeOcorrencias().isEmpty()) {
//			return this;
//		}
//		System.out.println("\n\n ------ Listando central de ocorrencias ------\n\n");
//
//		int i = 0;
//
//		for (CentralDeOcorrencia centralDeOcorrencia : daoOcorrencia.getListCentralDeOcorrencias()) {
//			System.out.println("Indice: " + i + ") " + centralDeOcorrencia);
//			i++;
//		}
//		System.out.print("Selecione a central pelo indice:");
//
//		int indice = scanner.nextInt();
//
//		if (indice < daoOcorrencia.getListCentralDeOcorrencias().size()) {
//			return daoOcorrencia.getListCentralDeOcorrencias().get(indice);
//		}
//
//		return this;
//	}

}
