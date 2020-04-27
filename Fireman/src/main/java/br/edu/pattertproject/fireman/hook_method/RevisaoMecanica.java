package br.edu.pattertproject.fireman.hook_method;

public class RevisaoMecanica extends Revisao {

	@Override
	public double revisaoDoDia(double valor) {

		setValorRevisao(valor * 6.0) ;
		return getValorRevisao();
	}

	@Override
	public double revisaoDoMes(double valor) {
		setValorRevisao((revisaoDoDia(valor) * 0.60) + getValorRevisao());
		return getValorRevisao();
	}

	@Override
	public double revisaoAnual(double valor) {
		setValorRevisao(revisaoDoMes(valor) * revisaoDoDia(valor) + getValorRevisao());
		return getValorRevisao();
	}

	@Override
	public String toString() {
		return "Revisao Mecanica :" + getValorRevisao();
	}
}
