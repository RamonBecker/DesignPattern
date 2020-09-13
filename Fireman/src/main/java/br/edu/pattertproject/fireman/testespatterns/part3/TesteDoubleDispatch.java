package br.edu.pattertproject.fireman.testespatterns.part3;

import br.edu.pattertproject.fireman.part3.doubledispatch.Atendimento_Pre_Hospitalar;
import br.edu.pattertproject.fireman.part3.doubledispatch.Endereco;
import br.edu.pattertproject.fireman.part3.doubledispatch.Extintor;
import br.edu.pattertproject.fireman.part3.doubledispatch.Incendio;
import br.edu.pattertproject.fireman.part3.doubledispatch.PranchaResgate;
import br.edu.pattertproject.fireman.part3.doubledispatch.RelatorioOcorrencia;
import br.edu.pattertproject.fireman.part3.doubledispatch.Sintomas;
import br.edu.pattertproject.fireman.part3.doubledispatch.TipoOcorrencia;

public class TesteDoubleDispatch {
	public static void main(String[] args) {

		RelatorioOcorrencia relatorioOcorrencia = new RelatorioOcorrencia();
		
		// Atendimento pré hospitalar
		Endereco endereco1 = new Endereco("Rua 1", "Bairro 1", "Cidade 1");
		
		Atendimento_Pre_Hospitalar atendimento_Pre_Hospitalar = new Atendimento_Pre_Hospitalar(endereco1);
		atendimento_Pre_Hospitalar.setSintomas(Sintomas.DESMAIO);
		
		PranchaResgate pranchaResgate = new PranchaResgate(200.0, 1, 20.5);
		pranchaResgate.setModelo("Prancha Resgate");
		pranchaResgate.setTipoOcorrencia(TipoOcorrencia.ATENDIMENTO_PRE_HOSPITALAR);
		
		atendimento_Pre_Hospitalar.getLista_Equipamentos().add(pranchaResgate);
		
		relatorioOcorrencia.addOcorrencia(atendimento_Pre_Hospitalar);

		// Incêndio
		Endereco endereco2 = new Endereco("Rua", "Bairro", "Cidade");
		
		Incendio incendio = new Incendio(endereco2);
		
		Extintor extintor1 = new Extintor(10.0, 2, 3);
		extintor1.setModelo("Extintor A");
		extintor1.setTipoOcorrencia(TipoOcorrencia.INCENDIO);
		
		Extintor extintor2 = new Extintor(10.0, 2, 3);
		extintor2.setModelo("Extintor A");
		extintor2.setTipoOcorrencia(TipoOcorrencia.INCENDIO);
		
		incendio.getLista_Equipamentos().add(extintor1);
		incendio.getLista_Equipamentos().add(extintor2);
		
		//Relatorio
	
		relatorioOcorrencia.addOcorrencia(incendio);
		relatorioOcorrencia.getTotalGastos();
		System.out.println(relatorioOcorrencia.getLista());
		System.out.println(relatorioOcorrencia.getLista_de_custo_Equipamento());
	}
}
