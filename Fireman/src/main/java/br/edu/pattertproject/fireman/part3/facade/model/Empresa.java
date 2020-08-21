package br.edu.pattertproject.fireman.part3.facade.model;

import br.edu.pattertproject.fireman.part1.entites.documents.Documento;
import br.edu.pattertproject.fireman.part1.entites.person.PessoaJuridica;
import br.edu.pattertproject.fireman.part1.state_pattern.InterfaceEstado;
import br.edu.pattertproject.fireman.part1.strategy_pattern.StrategyTaxa;


public class Empresa extends PessoaJuridica {

	private double taxa;
	private StrategyTaxa strategyTaxa;
	private InterfaceEstado interfaceEstado;
	private InterfaceEstado estadoPagamento;
	private Vistoria vistoria;
	private String ocupacao;

	public Empresa() {
	}

	public Empresa(Documento documento, String razaoSocial, String nomeFantasia, String ocupacao) {
		super(documento, razaoSocial, nomeFantasia);
		this.ocupacao = ocupacao;
	}

	public void solicitarVistoria() {
		this.estadoPagamento = interfaceEstado.processaPagamento(this);
	}

	public StrategyTaxa getStrategyTaxa() {
		return strategyTaxa;
	}

	public void setStrategyTaxa(StrategyTaxa strategyTaxa) {
		this.strategyTaxa = strategyTaxa;
	}

	public InterfaceEstado getInterfaceEstado() {
		return interfaceEstado;
	}

	public void setInterfaceEstado(InterfaceEstado interfaceEstado) {
		this.interfaceEstado = interfaceEstado;
	}

	public void setTaxa(double valor) {

		this.taxa = valor;
	}

	public void gerarTaxa(double valor) {

		if (valor > 0) {
			this.taxa += strategyTaxa.calcularTaxa(valor);
			return;
		}
		this.taxa = strategyTaxa.calcularTaxa(valor);
	}

	public double getTaxa() {
		return taxa;
	}

	public Vistoria getVistoria() {
		return vistoria;
	}

	public String getOcupacao() {
		return ocupacao;
	}

	public void setOcupacao(String ocupacao) {
		this.ocupacao = ocupacao;
	}

	public void setVistoria(Vistoria vistoria) {
		this.vistoria = vistoria;
	}

	public InterfaceEstado getEstadoPagamento() {
		return estadoPagamento;
	}

	@Override
	public String toString() {
		return "Empresa : Nome fantasia:" + getNomeFantasia() + ", CNPJ:" + getDocumento().getNumeroDocumento()
				+ ", Razão Social:" + getRazaoSocial() + ", Taxa:" + getTaxa() + ", Ocupação comercial:" + getOcupacao()
				+ " " + "Vistoria:" + vistoria + "\n";
	}

}
