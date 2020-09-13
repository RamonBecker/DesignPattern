package br.edu.pattertproject.fireman.testespatterns.part3;

import br.edu.pattertproject.fireman.part3.flyweight.Bloco;
import br.edu.pattertproject.fireman.part3.flyweight.Documento;
import br.edu.pattertproject.fireman.part3.flyweight.DocumentoCNPJ;
import br.edu.pattertproject.fireman.part3.flyweight.Edificacao;
import br.edu.pattertproject.fireman.part3.flyweight.Empresa;
import br.edu.pattertproject.fireman.part3.flyweight.FlyweigthFactory;
import br.edu.pattertproject.fireman.part3.flyweight.TipoTaxa;

public class TesteFlyweight {
	public static void main(String[] args) {

		Edificacao edificacao = new Edificacao(200.0, new Bloco(150.0));

		Documento documento = new DocumentoCNPJ("66210559000154");
		Empresa empresa = new Empresa(documento, "Razao social", "Nome fantasia", "Ocupação");
		edificacao.getBloco().setEmpresa(empresa);
		FlyweigthFactory factory = new FlyweigthFactory();
		try {
			factory.setEdificacao(edificacao);
			factory.getTaxa(empresa, TipoTaxa.TAXAFUNCIONAMENTO);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		System.out.println(empresa.getTaxa().getValor());
	}
}
