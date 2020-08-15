package br.edu.pattertproject.fireman.part3.command;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


public class Motor {
	private HashMap<Integer, List<Double>> velocidades;

	public HashMap<Integer, List<Double>> getVelocidades() {
		if (velocidades == null) {
			velocidades = new HashMap<Integer, List<Double>>();
			velocidades.put(1, new ArrayList<>());
			velocidades.put(2, new ArrayList<>());
			velocidades.put(3, new ArrayList<>());
			velocidades.put(4, new ArrayList<>());
			velocidades.put(5, new ArrayList<>());
		}
		return velocidades;
	}

}
