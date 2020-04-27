package br.edu.pattertproject.fireman.observer_pattern;

public interface Observer {
	public void notificar(Observable observable);

	public void update(Observable observable);
}
