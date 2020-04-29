package br.edu.pattertproject.fireman.part2.chan_responsibility_pattern;

import java.util.HashMap;
import java.util.Map;
import br.edu.pattertproject.fireman.exception.ErrorSearchDado;
import br.edu.pattertproject.fireman.part1.entites.Empresa;
import br.edu.pattertproject.fireman.part1.observer_pattern.Viatura;

public abstract class RecuperarDado {

	protected RecuperarDado recuperador;
	protected Map<String, Empresa> listsEmpresas;
	protected Map<String, Viatura> listsViaturas;

	public RecuperarDado() {
		super();
	}

	public RecuperarDado(RecuperarDado recuperador) {
		this.recuperador = recuperador;
	}

	public <T, K, V> Object buscarDado(String nome) throws ErrorSearchDado {
		
		Object dadoBuscado = recuperarDado(nome);

		if (dadoBuscado == null) {
			return chamarRecuperador(nome);
		}

		return dadoBuscado;
	}

	private <T, K, V> Object chamarRecuperador(String nome) throws ErrorSearchDado {
		if (this.recuperador == null) {
			throw new ErrorSearchDado("Não foi possível buscar essa informação");
		}
		return recuperador.buscarDado(nome);
	}

	protected abstract <K, V> Object buscarLista(Map<K, V> map, String nome);

	protected abstract <K, V> Object recuperarDado(String nome);

	public RecuperarDado getRecuperador() {
		return recuperador;
	}

	public RecuperarDado setRecuperador(RecuperarDado recuperador) {
		this.recuperador = recuperador;
		return recuperador;
	}

	public Map<String, Empresa> getListsEmpresas() {
		if (listsEmpresas == null) {
			listsEmpresas = new HashMap<>();
		}
		return listsEmpresas;
	}

	public void setListsEmpresas(Map<String, Empresa> listsEmpresas) {
		this.listsEmpresas = listsEmpresas;
	}

	public Map<String, Viatura> getListsViaturas() {
		if (listsViaturas == null) {
			listsViaturas = new HashMap<>();
		}
		return listsViaturas;
	}

	public void setListsViaturas(Map<String, Viatura> listsViaturas) {
		this.listsViaturas = listsViaturas;
	}
}
