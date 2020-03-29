package br.edu.pattertproject.fireman.Fireman.hook_method;

public class RevisaoMecanica extends Revisao {

	@Override
	public double revisaoDoDia() {

		setValorRevisao(500);
		return getValorRevisao();
	}

	@Override
	public double revisaoDoMes() {
		setValorRevisao((revisaoDoDia() * 0.60) + getValorRevisao());
		return getValorRevisao();
	}

	@Override
	public double revisaoAnual() {
		setValorRevisao(revisaoDoMes() * revisaoDoDia() + getValorRevisao());
		return getValorRevisao();
	}

	@Override
	public String toString() {
		return "Revisao Mecanica :" + getValorRevisao();
	}
}
