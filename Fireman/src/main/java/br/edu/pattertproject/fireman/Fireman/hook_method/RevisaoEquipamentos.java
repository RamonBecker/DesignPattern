package br.edu.pattertproject.fireman.Fireman.hook_method;

public class RevisaoEquipamentos extends Revisao {

	@Override
	public double revisaoDoDia() {
		setValorRevisao(100);
		return getValorRevisao();
	}

	@Override
	public double revisaoDoMes() {

		setValorRevisao((getValorRevisao() * 0.50) + revisaoDoDia());

		return getValorRevisao();
	}

	@Override
	public double revisaoAnual() {

		setValorRevisao((revisaoDoMes() * revisaoDoDia()) + 1000);

		return getValorRevisao();
	}

	@Override
	public String toString() {
		return "Revisao Equipamentos:"+getValorRevisao();
	}
	
}
