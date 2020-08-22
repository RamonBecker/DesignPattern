package br.edu.pattertproject.fireman.testespatterns.part3;

import br.edu.pattertproject.fireman.part3.facade.control.EmpresaServico;
import br.edu.pattertproject.fireman.part3.facade.model.empresa.Documento;
import br.edu.pattertproject.fireman.part3.facade.model.empresa.DocumentoCNPJ;

public class TesteFacade {

	public static void main(String[] args) {
		
		EmpresaServico empresa = new EmpresaServico();
		Documento doc = new DocumentoCNPJ("87051293000114");
		empresa.add(doc, "Nome fantasiaa", "Razao Social", "Ocupação");
		
		empresa.buscar("8705129300011");
		empresa.listar();
		
		
	}

}
