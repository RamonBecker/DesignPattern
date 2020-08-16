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
	private int marchaAtual;
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

		double aux_calc = 0;

		for (int i = 0; i < marcharAtual; i++) {
			aux_calc += calcDivisao;
			velocidadesMarcha.add(aux_calc);
		}

		for (int i = 0; i < velocidadesMarcha.size(); i++) {
			if (velocidadesMarcha.get(i) <= 5.0) {
				addVelocidadeMotor(1, i);
			}
		}

		if (motor.getVelocidades().containsKey(1)) {
			List<Double> recuperar = motor.getVelocidades().get(1);
			if (recuperar.isEmpty()) {
				recuperar.add(0.0);
				motor.getVelocidades().put(1, recuperar);
			}
		}

		marchaAtual = 1;
		double velocidadeLimite = 0;
		int contKey = 1;

		boolean verificando_velocidade_limitese;
		for (int i = 0; i < velocidadesMarcha.size(); i++) {
			velocidadeLimite = velocidades.get(contKey);
			if (velocidadesMarcha.get(i) > velocidadeLimite) {
				marchaAtual++;
				addVelocidadeMotor(marchaAtual, i);

			} else if (velocidadesMarcha.get(i) <= velocidadeLimite) {

				contKey--;

				if (velocidades.containsKey(contKey)) {
					velocidadeLimite = velocidades.get(contKey);
					if (velocidadesMarcha.get(i) > velocidadeLimite) {
						contKey++;
						checkVverificando_velocidade_limite			velocidadeLimite = velocidades.get(contKey);
						if (velocidadeLimite < velocidadesMarcha.get(i)) {
							marchaAtual++;
						}
						addVelocidadeMotor(marchaAtual, i);
					}

				}
				if (checkVelocidverificando_velocidade_limite;
					checkVelocidadeLimverificando_velocidade_limite	contKey++;
		}

		System.out.println("------------");
		System.out.println("Velocidade Atual:" + velocidadeRecebida);
		System.out.println("Marcha atual:" + (cont + 1));
		marchaAtual = cont + 1;
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

	public int getMarchaAtual() {
		return marchaAtual;
	}

}
