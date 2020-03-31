package br.edu.pattertproject.fireman.Fireman.hook_method;

public abstract class Revisao {

	private double valorRevisao;

	public void orcamento(double revisaoDia, double revisaoMes, double revisaoAnual) {

		System.out.println("Revisao do dia:" + revisaoDoDia(revisaoDia));
		System.out.println("Revisao do mês:" + revisaoDoMes(revisaoMes));
		System.out.println("Revisao anual:" + revisaoAnual(revisaoAnual));

	}

	public abstract double revisaoDoDia(double valor);

	public abstract double revisaoDoMes(double valor);

	public abstract double revisaoAnual(double valor);

	public double getValorRevisao() {
		return valorRevisao;
	}

	public void setValorRevisao(double valorRevisao) {
		this.valorRevisao = valorRevisao;
	}

	@Override
	public String toString() {
		return "Revisao [valorRevisao=" + valorRevisao + "]";
	}

}
