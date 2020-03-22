package br.edu.pattertproject.fireman.Fireman.strategy_pattern;

import br.edu.pattertproject.fireman.Fireman.entites.Empresa;
import br.edu.pattertproject.fireman.Fireman.entites.Usuario;

public  class Vistoria {
	private Usuario usuario;
	private Empresa empresa;
	private double taxa;
	private String data;
	private StrategyTaxa strategyTaxa;

	public StrategyTaxa getStrategyTaxa() {
		return strategyTaxa;
	}

	public void setStrategyTaxa(StrategyTaxa strategyTaxa) {
		this.strategyTaxa = strategyTaxa;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Empresa getEmpresa() {
		return empresa;
	}

	public void setEmpresa(Empresa empresa) {
		this.empresa = empresa;
	}

	public double getTaxa() {
		return taxa;
	}

	public void setTaxa(double valor) {

		this.taxa = strategyTaxa.calcularTaxa(valor);
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}
}
