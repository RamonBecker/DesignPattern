package br.edu.pattertproject.fireman.Fireman.observer_pattern;

import java.util.ArrayList;
import java.util.List;

public class Viatura implements Observable {
	private Ocorrencia ocorrencia;
	private String nome;
	private String modelo;
	private String estado;
	private List<Observer> listObserver;

	public Viatura() {
		this.listObserver = new ArrayList<Observer>();
	}

	public Viatura(String nome, String modelo) {
		this.nome = nome;
		this.modelo = modelo;
		this.listObserver = new ArrayList<Observer>();
	}

	@Override
	public void addObserver(Observer observer) {
		listObserver.add(observer);
	}

	@Override
	public void removeObserver(Observer observer) {
		listObserver.add(observer);
	}

	@Override
	public void notify(String message) {

		this.estado = message;
		for (Observer observer : listObserver) {
			System.out.println(this + " notificando: " + observer);
			observer.notificar(this);
		}

	}

	public Ocorrencia getOcorrencia() {
		return ocorrencia;
	}

	public void setOcorrencia(Ocorrencia ocorrencia) {
		this.ocorrencia = ocorrencia;
	}

	@Override
	public String recuperarEstado() {
		return this.estado;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public List<Observer> getListObserver() {
		return listObserver;
	}

	public void setListObserver(List<Observer> listObserver) {
		this.listObserver = listObserver;
	}

	@Override
	public String toString() {
		return "Viatura:" + nome + ", modelo:" + modelo;
	}

}
