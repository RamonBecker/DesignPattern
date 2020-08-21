package br.edu.pattertproject.fireman.testespatterns.part3;

import br.edu.pattertproject.fireman.part3.doubledispatch.Endereco;
import br.edu.pattertproject.fireman.part3.doubledispatch.Extintor;
import br.edu.pattertproject.fireman.part3.doubledispatch.Incendio;
import br.edu.pattertproject.fireman.part3.doubledispatch.RelatorioOcorrencia;
import br.edu.pattertproject.fireman.part3.doubledispatch.TipoOcorrencia;

public class TesteDoubleDispatch {
	public static void main(String[] args) {

		Endereco endereco = new Endereco("Rua", "Bairro", "Cidade");
		Incendio incendio = new Incendio(endereco);
		Extintor extintor1 = new Extintor(10.0, 2, 3);
		extintor1.setModelo("Extintor A");
		extintor1.setTipoOcorrencia(TipoOcorrencia.INCENDIO);
		Extintor extintor2 = new Extintor(10.0, 2, 3);
		extintor2.setModelo("Extintor A");
		extintor2.setTipoOcorrencia(TipoOcorrencia.INCENDIO);
		incendio.getLista_Equipamentos().add(extintor1);
		incendio.getLista_Equipamentos().add(extintor2);
		RelatorioOcorrencia relatorioOcorrencia = new RelatorioOcorrencia();
		relatorioOcorrencia.addOcorrencia(incendio);
		System.out.println(relatorioOcorrencia.getLista());
	}
}
