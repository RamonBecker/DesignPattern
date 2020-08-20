package br.edu.pattertproject.fireman.testespatterns.part3;

import br.edu.pattertproject.fireman.part3.doubledispatch.Endereco;
import br.edu.pattertproject.fireman.part3.doubledispatch.Equipamento;
import br.edu.pattertproject.fireman.part3.doubledispatch.Incendio;
import br.edu.pattertproject.fireman.part3.doubledispatch.RelatorioOcorrencia;
import br.edu.pattertproject.fireman.part3.doubledispatch.TipoIncendio;

public class TesteDoubleDispatch {
	public static void main(String[] args) {
		
		Endereco endereco = new Endereco("Rua", "Bairro", "Cidade");
		Incendio incendio = new Incendio(endereco);
		
		incendio.getLista_Equipamentos_Utilizados().put(1, new Equipamento("Extintor", 100.0, 2));
		incendio.getLista_Equipamentos_Utilizados().put(2, new Equipamento("Extintor", 100.0, 1));
		incendio.setTipoIncendio(TipoIncendio.CLASSE_A);
		RelatorioOcorrencia relatorioOcorrencia = new RelatorioOcorrencia();
		relatorioOcorrencia.addOcorrencia(incendio);		
		System.out.println(relatorioOcorrencia.getLista_de_custos_de_equipamentos());
	}
}
