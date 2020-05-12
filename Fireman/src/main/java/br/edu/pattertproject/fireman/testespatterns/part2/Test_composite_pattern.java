package br.edu.pattertproject.fireman.testespatterns.part2;

import java.text.ParseException;
import java.util.Random;
import br.edu.pattertproject.fireman.part1.entites.person.Endereco;
import br.edu.pattertproject.fireman.part1.observer_pattern.Ocorrencia;
import br.edu.pattertproject.fireman.part1.observer_pattern.Viatura;
import br.edu.pattertproject.fireman.part2.composite_pattern.ITrecho;
import br.edu.pattertproject.fireman.part2.composite_pattern.Trecho;
import br.edu.pattertproject.fireman.part2.composite_pattern.TrechoComposto;

public class Test_composite_pattern {
	public static void main(String[] args) {

		try {

			Random gerarSemente = new Random();

			Endereco enderecoOcorrencia = new Endereco("Rua 10 de Julho", "Vila", "Canoinhas", "75");
			Endereco origemA = new Endereco("Rua 12 de setembro", "Centro", "Canoinhas");
			Endereco destinoA = new Endereco("15 de novembro", "Boa vista", "Canoinhas");
			
			Ocorrencia ocorrencia = new Ocorrencia(enderecoOcorrencia);
			Viatura viatura = new Viatura(ocorrencia, "Viatura", "0005", 75);

			ITrecho trechoA = new Trecho(origemA, destinoA);
			ITrecho trechoB = new Trecho(destinoA, viatura.getOcorrencia().getEndereco());
			ITrecho trechoC = new Trecho(ocorrencia.getEndereco(), null);

			gerar_ponto(trechoA, gerarSemente.nextInt(100));
			gerar_ponto(trechoB, gerarSemente.nextInt(200));
			gerar_ponto(trechoC, gerarSemente.nextInt(600));

			ITrecho trechoAB = new TrechoComposto(trechoA, trechoB, viatura);

			System.out.println("---------------- Trecho A ao B ----------------");
			
			((TrechoComposto) trechoAB).calcTempoPercorrido();

			((TrechoComposto) trechoAB).calcDeslocamento();

			((TrechoComposto) trechoAB).calcVelocidadeMedia();

			System.out.println("------------------------------------------");

			ITrecho trechoFinal = new TrechoComposto(trechoAB, trechoC, viatura);

			System.out.println("-------------------- Trecho Final do AB ao C --------------------");

			((TrechoComposto) trechoFinal).calcTempoPercorrido();
			((TrechoComposto) trechoFinal).calcDeslocamento();
			((TrechoComposto) trechoFinal).calcVelocidadeMedia();

			System.out.println("------------------------------------------");

		} catch (ParseException e) {
			e.printStackTrace();
		}
	}

	private static void gerar_ponto(ITrecho trecho, int n) {
		double distancia = gerarDistancia(n);
		trecho.setDistancia(distancia);
	}

	private static int gerarDistancia(int n) {
		Random random = new Random();

		int distancia = random.nextInt(n);

		if (distancia == 0) {
			distancia = random.nextInt(n);
		}

		return distancia;
	}
}
