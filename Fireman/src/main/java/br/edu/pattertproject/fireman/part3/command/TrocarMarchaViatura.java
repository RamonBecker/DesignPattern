package br.edu.pattertproject.fireman.part3.command;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

import br.edu.pattertproject.fireman.part3.fluent_interfaces.Viatura;

public class TrocarMarchaViatura implements Comando {

	public static int velocidadeRecebida;
	private Viatura viatura;
	private TreeMap<Integer, Double> velocidades;
	private Motor motor = new Motor();
	private List<Double> velocidadesMarcha = new ArrayList<Double>();

	{
		velocidades = new TreeMap<Integer, Double>();
		velocidades.put(1, 5.0);
		velocidades.put(2, 20.0);
		velocidades.put(3, 35.0);
		velocidades.put(4, 85.0);
		velocidades.put(5, 160.0);
	}

	@Override
	public void executar() {
		
		
		
		
		

		int cont = 0;
		for (Integer key : velocidades.keySet()) {
			double velocidade = velocidades.get(key);
			if (velocidadeRecebida > velocidade) {
				cont++;
			}
		}

		double marcharAtual = cont + 1;
		double calcDivisao = velocidadeRecebida / marcharAtual;

		ArrayList<Double> list1 = new ArrayList<Double>();

		double aux_calc = 0;

		for (int i = 0; i < marcharAtual; i++) {
			aux_calc += calcDivisao;
			velocidadesMarcha.add(aux_calc);
		}

		int marchaAtual = 1;
		double velocidadeLimite = 0;
		int contKey = 1;

		boolean teste = false;
		for (int i = 0; i < velocidadesMarcha.size(); i++) {
			velocidadeLimite = velocidades.get(contKey);
			if (velocidadesMarcha.get(i) > velocidadeLimite) {
				marchaAtual++;
				addVelocidadeMotor(marchaAtual, i);

			} else if (velocidadesMarcha.get(i) < velocidadeLimite) {

				contKey--;
				
				if (velocidades.containsKey(contKey)) {
					velocidadeLimite = velocidades.get(contKey);
					if (velocidadesMarcha.get(i) > velocidadeLimite) {
						contKey++;
						teste = true;
						velocidadeLimite = velocidades.get(contKey);
						if (velocidadeLimite < velocidadesMarcha.get(i)) {
							marchaAtual++;
						}
						addVelocidadeMotor(marchaAtual, i);
					}

				}
				if (teste) {
					contKey--;
					teste = false;

				}
			}
			contKey++;
		}

		System.out.println("------------");
		System.out.println("Velocidade Atual:" + velocidadeRecebida);
		System.out.println("Marcha atual:" + (cont + 1));

		System.out.println("lista:" + list1);
		System.out.println("lista do motor:" + motor.getVelocidades());

	}

	private void addVelocidadeMotor(Integer marchaAtual, int posicao) {

		List<Double> list = motor.getVelocidades().get(marchaAtual);
		list.add(velocidadesMarcha.get(posicao));
		motor.getVelocidades().put(marchaAtual, list);
	}

	public Viatura getViatura() {
		return viatura;
	}

	public void setViatura(Viatura viatura) {
		this.viatura = viatura;
	}

}
