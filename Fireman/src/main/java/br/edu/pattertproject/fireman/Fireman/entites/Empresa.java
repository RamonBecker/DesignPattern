package br.edu.pattertproject.fireman.Fireman.entites;

import br.edu.pattertproject.fireman.Fireman.entites.Pessoa.PessoaJuridica;
import br.edu.pattertproject.fireman.Fireman.state_pattern.InterfaceEstado;
import br.edu.pattertproject.fireman.Fireman.state_pattern.strategy_pattern.StrategyTaxa;
import br.edu.pattertproject.fireman.Fireman.state_pattern.strategy_pattern.TaxaAnual;

public class Empresa extends PessoaJuridica {

	private double taxa;
	private StrategyTaxa strategyTaxa;
	private InterfaceEstado interfaceEstado;
	private Vistoria vistoria;
	private String ocupacao;

	public Empresa(String nome, String razaoSocial) {
		super(nome, razaoSocial);

		// Utilizando o strategy
		setStrategyTaxa(new TaxaAnual());
		gerarTaxa(100);

	}

	public void solicitarVistoria() {
		if (interfaceEstado.processaPagamento(this)) {
			System.out.println("O pagamento esta quitado");
			System.out.println("A empresa esta liberada para solicitar uma nova vistoria");
		} else {
			System.out.println("A empresa não pode solicitar nova vistoria, pois esta com pendencia em pagamento: 			"+this.taxa+ " reais");

		}
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

}
