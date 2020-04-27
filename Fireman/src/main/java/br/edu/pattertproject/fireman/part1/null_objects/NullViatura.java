package br.edu.pattertproject.fireman.part1.null_objects;


import java.util.List;
import br.edu.pattertproject.fireman.part1.hook_method.Revisao;
import br.edu.pattertproject.fireman.part1.observer_pattern.Observer;
import br.edu.pattertproject.fireman.part1.observer_pattern.Ocorrencia;
import br.edu.pattertproject.fireman.part1.observer_pattern.Viatura;
	

public class NullViatura extends Viatura {

	public NullViatura() {
	}
	
	public String getEstado() {
		return null;
	}
	
	public Ocorrencia getOcorrencia() {
		return null;
	}
	
	@Override
	public String recuperarEstado() {
		return null;
	}
	
	public String getNome() {
		return null;
	}

	public String getModelo() {
		return null;
	}


	public List<Observer> getListObserver() {
		return null;
	}
	public Revisao getRevisao() {
		return null;
	}



	@Override
	public String toString() {
		return "Null Viatura";
	}

}
