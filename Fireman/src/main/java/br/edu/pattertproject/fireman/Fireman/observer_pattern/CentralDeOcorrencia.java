package br.edu.pattertproject.fireman.Fireman.observer_pattern;

import br.edu.pattertproject.fireman.Fireman.entites.Pessoa.Usuario;

public class CentralDeOcorrencia implements Observer {
	private Usuario operador;
	private String estadoViatura;

	public CentralDeOcorrencia() {
	}

	public CentralDeOcorrencia(Usuario operador) {
		this.operador = operador;

	}

	@Override
	public void notificar(Observable observable) {

		System.out.println(
				"Central recebeu a notificação " + observable + " e seu estado: " + observable.recuperarEstado());
		update(observable);
	}

	@Override
	public void update(Observable observable) {
		System.out.println("Central atualizando dados do estado da viatura na ocorrência");
		this.estadoViatura = observable.recuperarEstado();
	}

	public Usuario getOperador() {
		return operador;
	}

	public void setOperador(Usuario operador) {
		this.operador = operador;
	}

	public String getEstadoViatura() {
		return estadoViatura;
	}

	public void setEstadoViatura(String estadoViatura) {
		this.estadoViatura = estadoViatura;
	}

	@Override
	public String toString() {
		return "CentralDeOcorrencia " + "Operador da central: " + operador;
	}

}
