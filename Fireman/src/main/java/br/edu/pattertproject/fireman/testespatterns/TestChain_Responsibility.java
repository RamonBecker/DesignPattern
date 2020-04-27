package br.edu.pattertproject.fireman.testespatterns;

import br.edu.pattertproject.fireman.exception.ErrorSearchDado;
import br.edu.pattertproject.fireman.part1.entites.Empresa;
import br.edu.pattertproject.fireman.part1.entites.documents.DocumentoCNPJ;
import br.edu.pattertproject.fireman.part2.chan_responsibility_pattern.CacheMemory;
import br.edu.pattertproject.fireman.part2.chan_responsibility_pattern.RecuperarDado;

public class TestChain_Responsibility {

	public static void main(String[] args) {

		Empresa empresa = new Empresa(new DocumentoCNPJ("07864837000128"), "Nome fantasia", "Razao Social",
				"Ocupacional");

		RecuperarDado recuperarDado = new CacheMemory();
		recuperarDado.getListsEmpresas().put(empresa.getDocumento().getNumeroDocumento(), empresa);

		try {
			Empresa ep = (Empresa) recuperarDado.buscarDado("07864837000128", recuperarDado.getListsEmpresas());
			System.out.println(ep);
		} catch (ErrorSearchDado e) {
			e.printStackTrace();
		}
	}
}
