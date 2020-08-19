package br.edu.pattertproject.fireman.part3.command;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

public class Motor {
	private TreeMap<Integer, List<Integer>> velocidades;
	private int marchaAtual;
	private TreeMap<Integer, Integer> velocidadesLimite;
	private static Motor motor;

	public static Motor getInstance() {
		if (motor == null) {
			motor = new Motor();
		}
		return motor;
	}

	public void executar(Comando comando) {
		comando.executar();
	}

	public TreeMap<Integer, List<Integer>> getVelocidades() {
		if (velocidades == null) {
			velocidades = new TreeMap<Integer, List<Integer>>();
			velocidades.put(1, new ArrayList<>());
			velocidades.put(2, new ArrayList<>());
			velocidades.put(3, new ArrayList<>());
			velocidades.put(4, new ArrayList<>());
			velocidades.put(5, new ArrayList<>());
		}
		return velocidades;
	}

	public TreeMap<Integer, Integer> getVelocidadesLimite() {
		if (velocidadesLimite == null) {
			velocidadesLimite = new TreeMap<Integer, Integer>();
			velocidadesLimite.put(1, 5);
			velocidadesLimite.put(2, 20);
			velocidadesLimite.put(3, 35);
			velocidadesLimite.put(4, 85);
			velocidadesLimite.put(5, 160);
		}
		return velocidadesLimite;
	}

	public int getMarchaAtual() {
		return marchaAtual;
	}

	public void setMarchaAtual(int marchaAtual) {
		if (marchaAtual == 0) {
			throw new IllegalArgumentException("A marcha não pode ser zero");
		}
		this.marchaAtual = marchaAtual;
	}

}
