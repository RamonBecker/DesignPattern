package br.edu.pattertproject.fireman.Fireman.observer_pattern;

public class CentralDeOcorrencia implements Observer {
	private String estadoViatura;

	public CentralDeOcorrencia() {
	}

	@Override
	public void notificar(Observable observable) {

		System.out.println(
				"Central recebeu a notificação de " + observable + " e seu estado: " + observable.recuperarEstado());
		update(observable);
	}

	@Override
	public void update(Observable observable) {
		System.out.println("Central atualizando dados do estado da viatura na ocorrência");
		this.estadoViatura = observable.recuperarEstado();
	}

	public String getEstadoViatura() {
		return estadoViatura;
	}

	public void setEstadoViatura(String estadoViatura) {
		this.estadoViatura = estadoViatura;
	}

	@Override
	public String toString() {
		return "Central de Ocorrencia ";
	}

}
