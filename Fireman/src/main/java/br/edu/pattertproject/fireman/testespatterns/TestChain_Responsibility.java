package br.edu.pattertproject.fireman.testespatterns;

import br.edu.pattertproject.fireman.chan_responsibility_pattern.CacheMemory;
import br.edu.pattertproject.fireman.chan_responsibility_pattern.RecuperarDado;
import br.edu.pattertproject.fireman.entites.Empresa;
import br.edu.pattertproject.fireman.entites.Pessoa.documento.documentoCNPJ;
import br.edu.pattertproject.fireman.exception.ErrorSearchDado;

public class TestChain_Responsibility {

	public static void main(String[] args) {

		Empresa empresa = new Empresa(new documentoCNPJ("07864837000128"), "Nome fantasia", "Razao Social",
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
