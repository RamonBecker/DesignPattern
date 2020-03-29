package br.edu.pattertproject.fireman.Fireman.hook_method;

public abstract class Revisao {

	private double valorRevisao;

	public void revisao() {

		revisaoDoDia();
		revisaoDoMes();
		revisaoAnual();

		System.out.println("Revisao do dia:" + revisaoDoDia());
		System.out.println("Revisao do mês:" + revisaoDoMes());
		System.out.println("Revisao anual:" + revisaoAnual());

	}

	public abstract double revisaoDoDia();

	public abstract double revisaoDoMes();

	public abstract double revisaoAnual();

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
